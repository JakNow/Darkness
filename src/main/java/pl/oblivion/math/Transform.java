package pl.oblivion.math;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.joml.Quaternionf;
import org.joml.Vector3f;

@Getter
@Setter
@AllArgsConstructor
public class Transform {

    private Vector3f position;
    private Quaternionf rotation;
    private Vector3f scale;

    public Transform(){
        this.position = new Vector3f();
        this.rotation = new Quaternionf();
        this.scale = new Vector3f(1.0f);
    }
}
