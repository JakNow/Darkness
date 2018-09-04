package pl.oblivion.renderer;

import org.lwjgl.opengl.GL11;
import pl.oblivion.window.Window;

public class Renderer {

    private Window window;
    private Camera camera;
    private float currentWidth;
    private float currentHeight;

    public Renderer(Window window, Camera camera) {
        this.window = window;
        this.camera = camera;
    }


    public void render() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glClearColor(0, 0, 0, 1.0f);
        GL11.glViewport(0, 0, window.getWidth(), window.getHeight());
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        if (currentWidth != window.getWidth() || currentHeight != window.getHeight()) {
            window.updateProjectMatrix(window.getProjectionMatrix(), window.getWidth(), window.getHeight());
            this.currentWidth = window.getWidth();
            this.currentHeight = window.getHeight();
        }
        renderModels();
        renderGUI();
    }

    private void renderModels() {

    }

    private void renderGUI() {

    }
}
