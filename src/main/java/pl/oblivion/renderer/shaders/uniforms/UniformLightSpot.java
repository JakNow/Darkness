package pl.oblivion.renderer.shaders.uniforms;

import pl.oblivion.scene.light.Light;
import pl.oblivion.scene.light.LightType;

public class UniformLightSpot extends UniformLight{

    private UniformFloat angle;

    public UniformLightSpot(String name) {
        super(name, new UniformLightType(name+".type",LightType.SPOT_LIGHT));
        this.angle = new UniformFloat(name+".angle");
    }

    @Override
    void loadLight(Light light) {
        //todo
    }
}
