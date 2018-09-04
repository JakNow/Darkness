package pl.oblivion.scene.model;

import pl.oblivion.scene.GameObject;

public class Model extends GameObject {

    private SkinnedMesh skinnedMesh;

    public Model(String name, SkinnedMesh skinnedMesh){
        super(name, Model.class);
        this.skinnedMesh = skinnedMesh;
    }
}
