package pl.oblivion.renderer.shaders.uniforms;

import org.lwjgl.opengl.GL20;

public class UniformBoolean extends Uniform {

    public UniformBoolean(String name) {
        super(name);
    }

    void loadBoolean(boolean bool) {
        GL20.glUniform1i(super.getLocation(), bool ? 1 : 0);
    }
}
