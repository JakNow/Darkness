package pl.oblivion.scene.mesh;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MeshData {

    private String name;
    private int[] indices;
    private float[] vertices;
    private float[] textures;
    private float[] normals;
    private float[] tangents;
    private float furthestPoint;

}
