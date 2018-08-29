package pl.oblivion.scene.mesh;

import lombok.Getter;
import lombok.Setter;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import java.util.Map;

@Getter
@Setter
public class Mesh {

    private static final int BYTES_PER_FLOAT = 4;
    private static final int BYTES_PER_INT = 4;
    private final int id;
    private Map<VertexBuffer.Type, VertexBuffer> vertexBufferMap;
    private VertexBuffer indexBuffer;
    private int indexCount;

    private MeshData meshData;

    public static Mesh create(MeshData meshData){
        int id = GL30.glGenVertexArrays();
        return new Mesh(id,meshData);
    }
    private Mesh(int id, MeshData meshData){
        this.id = id;
        this.meshData = meshData;
        this.initMesh();
    }

    private void initMesh(){
        this.bind();
        this.createIndexBuffer(meshData.getIndices());
        this.createAttribute(VertexBuffer.Type.Position,0,meshData.getVertices(),3);
        this.createAttribute(VertexBuffer.Type.TextureCoords,0,meshData.getTextures(),2);
        this.createAttribute(VertexBuffer.Type.Normal,0,meshData.getNormals(),3);
        this.unbind();

    }

    private void bind(){
        GL30.glBindVertexArray(id);
    }

    private void createIndexBuffer(int[] indices){
        this.indexBuffer = VertexBuffer.create(VertexBuffer.Type.Index);
        this.indexBuffer.bind(GL15.GL_ELEMENT_ARRAY_BUFFER);
        this.indexBuffer.storeData(GL15.GL_ELEMENT_ARRAY_BUFFER, indices);
        this.indexCount = indices.length;
    }

    private void createAttribute(VertexBuffer.Type type,int attribute, float[] data, int attributeSize){
        VertexBuffer buffer = VertexBuffer.create(type);
        buffer.bind(GL15.GL_ARRAY_BUFFER);
        buffer.storeData(GL15.GL_ARRAY_BUFFER,data);
        GL20.glVertexAttribPointer(attribute,attributeSize, GL11.GL_FLOAT,false,attributeSize*BYTES_PER_FLOAT,0);
        buffer.unbind(GL15.GL_ARRAY_BUFFER);
        vertexBufferMap.put(type,buffer);
    }

    private void unbind(){
        GL30.glBindVertexArray(0);
    }

    private void bind(int... attributes){
        bind();
        for (int attribute : attributes) {
            GL20.glEnableVertexAttribArray(attribute);
        }
    }

    private void unbind(int... attributes){
        for (int attribute : attributes) {
            GL20.glDisableVertexAttribArray(attribute);
        }
        unbind();
    }

    private void createAttrivute(VertexBuffer.Type type, int attribute, int[] data, int attributeSize){
        VertexBuffer buffer = VertexBuffer.create(type);
        buffer.bind(GL15.GL_ARRAY_BUFFER);
        buffer.storeData(GL15.GL_ARRAY_BUFFER,data);
        GL30.glVertexAttribIPointer(attribute, attributeSize, GL11.GL_INT, attributeSize * BYTES_PER_INT, 0);
        buffer.unbind(GL15.GL_ARRAY_BUFFER);
        vertexBufferMap.put(type, buffer);
    }

    private void delete(){
        GL30.glDeleteVertexArrays(id);
        vertexBufferMap.forEach((type,vertexBuffer)->vertexBuffer.delete());
        indexBuffer.delete();
    }
}
