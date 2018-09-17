package pl.oblivion.scene.light;

import lombok.Getter;
import lombok.Setter;
import org.joml.Vector4f;

@Getter
@Setter
public abstract class Light {

    private Vector4f color;
    private Attenuation attenuation;
    private final LightType lightType;

    public Light(LightType lightType){
        this.lightType = lightType;
    }
}
