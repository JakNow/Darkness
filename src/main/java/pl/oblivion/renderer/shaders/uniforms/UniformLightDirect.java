package pl.oblivion.renderer.shaders.uniforms;

import pl.oblivion.scene.light.Light;
import pl.oblivion.scene.light.LightDirect;
import pl.oblivion.scene.light.LightType;

public class UniformLightDirect extends UniformLight<LightDirect> {

    public UniformLightDirect(String name) {
        super(name, new UniformLightType(name+".type",LightType.DIRECT_LIGHT));
    }

    @Override
    public void loadLight(LightDirect lightDirect) {

    }
}
