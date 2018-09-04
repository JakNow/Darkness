package pl.oblivion.renderer.shaders.uniforms;

import org.joml.Matrix3f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL20;

import java.nio.FloatBuffer;

public class UniformMat3 extends Uniform{

    private FloatBuffer matrixBuffer = BufferUtils.createFloatBuffer(9);

    public UniformMat3(String name) {
        super(name);
    }

    private void loadMat3(Matrix3f matrix3f){
        matrix3f.get(matrixBuffer);
        matrixBuffer.flip();
        GL20.glUniformMatrix3fv(super.getLocation(),false,matrixBuffer);
    }
}
