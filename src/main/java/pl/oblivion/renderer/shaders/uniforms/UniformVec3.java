package pl.oblivion.renderer.shaders.uniforms;

import org.joml.Vector3f;
import org.lwjgl.opengl.GL20;

public class UniformVec3 extends Uniform {


    public UniformVec3(String name) {
        super(name);
    }

    private void loadVec3(Vector3f vector3f) {
        this.loadVec3(vector3f.x, vector3f.y, vector3f.z);
    }

    private void loadVec3(float x, float y, float z) {
        GL20.glUniform3f(super.getLocation(), x, y, z);
    }
}

