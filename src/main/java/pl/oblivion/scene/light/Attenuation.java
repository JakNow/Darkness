package pl.oblivion.scene.light;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Attenuation {

    private float constant;
    private float linear;
    private float exponent;

}
