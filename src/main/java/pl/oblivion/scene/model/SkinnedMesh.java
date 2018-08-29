package pl.oblivion.scene.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.oblivion.scene.material.Material;
import pl.oblivion.scene.mesh.Mesh;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkinnedMesh {

    private Mesh mesh;
    private Material material;
}
