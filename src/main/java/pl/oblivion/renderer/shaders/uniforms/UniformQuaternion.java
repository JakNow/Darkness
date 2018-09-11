package pl.oblivion.renderer.shaders.uniforms;

import org.joml.Quaternionf;
import org.lwjgl.opengl.GL20;

public class UniformQuaternion extends Uniform {

    public UniformQuaternion(String name) {
        super(name);
    }

    private void loadQuaternion(Quaternionf quaternionf){
        this.loadQuaternion(quaternionf.x,quaternionf.y,quaternionf.z,quaternionf.w);
    }

    private void loadQuaternion(float x, float y, float z, float w){
        GL20.glUniform4f(super.getLocation(),x,y,z,w);
    }
}
