package pl.oblivion.renderer.shaders.uniforms;

import pl.oblivion.scene.light.Light;
import pl.oblivion.scene.light.LightType;

public class UniformLightDirect extends UniformLight {

    public UniformLightDirect(String name) {
        super(name, new UniformLightType(name+".type",LightType.DIRECT_LIGHT));
    }

    @Override
    void loadLight(Light light) {
        //todo
    }
}
