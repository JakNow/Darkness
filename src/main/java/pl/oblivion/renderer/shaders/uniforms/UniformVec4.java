package pl.oblivion.renderer.shaders.uniforms;

import org.joml.Vector4f;
import org.lwjgl.opengl.GL20;

public class UniformVec4 extends Uniform {


    public UniformVec4(String name) {
        super(name);
    }

    private void loadVec4(Vector4f vector4f) {
        this.loadVec4(vector4f.x, vector4f.y, vector4f.z, vector4f.w);
    }

    private void loadVec4(float x, float y, float z, float w) {
        GL20.glUniform4f(super.getLocation(), x, y, z, w);
    }
}
