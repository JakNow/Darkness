package pl.oblivion.renderer.shaders.uniforms;

import pl.oblivion.scene.light.LightSpot;
import pl.oblivion.scene.light.LightType;

public class UniformLightSpot extends UniformLight<LightSpot>{

    private UniformFloat angle;

    public UniformLightSpot(String name) {
        super(name, new UniformLightType(name+".type",LightType.SPOT_LIGHT));
        this.angle = new UniformFloat(name+".angle");
    }

    @Override
    public void loadLight(LightSpot lightSpot) {

    }
}
