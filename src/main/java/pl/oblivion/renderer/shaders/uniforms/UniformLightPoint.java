package pl.oblivion.renderer.shaders.uniforms;

import pl.oblivion.scene.light.Light;
import pl.oblivion.scene.light.LightType;

public class UniformLightPoint extends UniformLight {

    public UniformLightPoint(String name) {
        super(name,new UniformLightType(name+".type",LightType.POINT_LIGHT));
    }


    @Override
    void loadLight(Light light) {
        //todo
    }
}
