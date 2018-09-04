package pl.oblivion.renderer.shaders.uniforms;

import org.lwjgl.opengl.GL20;

public class UniformInt extends Uniform {

    public UniformInt(String name) {
        super(name);
    }

    private void loadInt(int value) {
        GL20.glUniform1i(super.getLocation(), value);
    }
}
