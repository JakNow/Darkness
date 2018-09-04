package pl.oblivion.renderer;

import org.joml.Matrix4f;
import pl.oblivion.scene.GameObject;
import pl.oblivion.window.Window;

import static org.lwjgl.glfw.GLFW.*;

public class Camera extends GameObject {

    private Matrix4f viewMatrix = new Matrix4f();
    private Window window;

    public Camera(Window window) {
        super("camera", Camera.class);
        this.window = window;
    }

    public Matrix4f getViewMatrix() {
        return viewMatrix.identity().rotate(getTransform().getRotation()).translate(-getTransform().getPosition().x, -getTransform()
                .getPosition().y, -getTransform().getPosition().z);
    }

    public void update(float delta) {
        if (window.isKeyPressed(GLFW_KEY_W)) {
            getTransform().getPosition().z -= 0.5 * 100 * delta;
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            getTransform().getPosition().z += 0.5 * 100 * delta;
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            getTransform().getPosition().x -= 0.5 * 100 * delta;
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            getTransform().getPosition().x += 0.5 * 100 * delta;
        }
        if (window.isKeyPressed(GLFW_KEY_Z)) {
            getTransform().getPosition().y -= 0.5 * 100 * delta;
        }
        if (window.isKeyPressed(GLFW_KEY_X)) {
            getTransform().getPosition().y += 0.5 * 100 * delta;
        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            getTransform().getRotation().rotateX((float) Math.toRadians(20 * delta));
        }
        if (window.isKeyPressed(GLFW_KEY_E)) {
            getTransform().getRotation().rotateX((float) Math.toRadians(-20 * delta));
        }
    }
}
