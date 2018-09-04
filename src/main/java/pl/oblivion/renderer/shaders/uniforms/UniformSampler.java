package pl.oblivion.renderer.shaders.uniforms;

import org.lwjgl.opengl.GL20;

public class UniformSampler extends Uniform {

    public UniformSampler(String name) {
        super(name);
    }

    public void loadTextureUnit(int textureUnit) {
        GL20.glUniform1i(super.getLocation(), textureUnit);
    }
}
