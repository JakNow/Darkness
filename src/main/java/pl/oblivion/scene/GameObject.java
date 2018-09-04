package pl.oblivion.scene;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.oblivion.math.Transform;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public abstract class GameObject<T> {

    private final String name;

    @Getter(AccessLevel.NONE)
    private final T t;
    private Transform transform;
    private List<GameObject> children;
    private GameObject parent;

    public GameObject(String name, T t){
        this.t = t;
        this.name = name;
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
