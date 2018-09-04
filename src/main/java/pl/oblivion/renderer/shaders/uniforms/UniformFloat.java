package pl.oblivion.renderer.shaders.uniforms;

import org.lwjgl.opengl.GL20;

public class UniformFloat extends Uniform {

    public UniformFloat(String name) {
        super(name);
    }

    private void loadFloat(float value) {
        GL20.glUniform1f(super.getLocation(), value);
    }
}
