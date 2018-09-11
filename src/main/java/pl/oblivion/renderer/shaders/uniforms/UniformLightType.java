package pl.oblivion.renderer.shaders.uniforms;

import org.lwjgl.opengl.GL20;
import pl.oblivion.scene.light.LightType;

public class UniformLightType extends Uniform {

    public UniformLightType(String name, LightType type) {
        super(name);
        loadLightType(type);
    }

    void loadLightType(LightType lightType) {
        switch (lightType) {
            case SPOT_LIGHT:
                GL20.glUniform1i(super.getLocation(), 1);
                break;
            case POINT_LIGHT:
                GL20.glUniform1i(super.getLocation(), 2);
                break;
            case DIRECT_LIGHT:
                GL20.glUniform1i(super.getLocation(), 3);
                break;
            default:
                GL20.glUniform1i(super.getLocation(), 0);
        }
    }
}
