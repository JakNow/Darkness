package pl.oblivion.renderer.shaders.uniforms;

import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL20;

import java.nio.FloatBuffer;

public class UniformMat4 extends Uniform {

    private FloatBuffer matrixBuffer = BufferUtils.createFloatBuffer(16);

    public UniformMat4(String name) {
        super(name);
    }

    public void loadMat4(Matrix4f matrix4f){
        matrix4f.get(matrixBuffer);
        matrixBuffer.flip();
        GL20.glUniformMatrix4fv(super.getLocation(),false,matrixBuffer);
    }
}
