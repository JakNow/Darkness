package pl.oblivion.scene;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.oblivion.math.Transform;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public abstract class GameObject {

    private Transform transform;
    private List<GameObject> children;
    private GameObject parent;

    public GameObject(){
        this.transform = new Transform();
        this.children = new LinkedList<>();
    }

    public boolean addChild(GameObject gameObject){
        children.add(gameObject);
        gameObject.setParent(this);
        return true;
    }

    public boolean detachChild(GameObject gameObject){
        if(gameObject.getParent() == this){
            children.remove(gameObject);
            gameObject.setParent(null);
            return true;
        }
        return false;
    }
}
