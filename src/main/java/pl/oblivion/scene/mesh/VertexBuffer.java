package pl.oblivion.scene.mesh;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL15;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glGenBuffers;

@Getter
@Setter
@AllArgsConstructor
class VertexBuffer {

    private final int id;
    private final Type type;

    static VertexBuffer create(Type type) {
        return new VertexBuffer(glGenBuffers(), type);
    }

    void bind(int type) {
        glBindBuffer(type, id);
    }

    void unbind(int type) {
        glBindBuffer(type, 0);
    }

    void storeData(int type, float[] data) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        GL15.glBufferData(type, buffer, GL15.GL_STATIC_DRAW);
    }

    void storeData(int type, int[] data) {
        IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        GL15.glBufferData(type, buffer, GL15.GL_STATIC_DRAW);
    }

    void delete() {
        GL15.glDeleteBuffers(id);
    }

    public enum Type {
        Index,
        Position,
        Size,
        Normal,
        TextureCoords,
        Color,
        Tangent
    }
}
