package pl.oblivion.renderer.shaders.uniforms;

import org.joml.Vector2f;
import org.lwjgl.opengl.GL20;

public class UniformVec2 extends Uniform {

    public UniformVec2(String name) {
        super(name);
    }

    private void loadVec2(Vector2f vector2f) {
        this.loadVec2(vector2f.x, vector2f.y);
    }

    private void loadVec2(float x, float y) {
        GL20.glUniform2f(super.getLocation(), x, y);
    }


}
