package pl.oblivion.renderer.shaders.uniforms;

import pl.oblivion.scene.light.LightPoint;
import pl.oblivion.scene.light.LightType;

public class UniformLightPoint extends UniformLight<LightPoint> {

    public UniformLightPoint(String name) {
        super(name,new UniformLightType(name+".type",LightType.POINT_LIGHT));
    }

    @Override
    public void loadLight(LightPoint lightDirect) {

    }
}
