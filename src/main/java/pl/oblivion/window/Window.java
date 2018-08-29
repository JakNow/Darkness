package pl.oblivion.window;

import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Properties;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {

    private final Matrix4f projectionMatrix;
    private long windowId;
    private String title;
    private int width;
    private int height;
    private boolean resized = false;
    private boolean vSync = true;

    private static float FOV;
    private static float NEAR;
    private static float FAR;

    private FloatBuffer fb;

    public Window(Properties properties) {
        this.title = properties.getProperty("window.display.title");
        this.width = Integer.valueOf(properties.getProperty("window.display.width"));
        this.height = Integer.valueOf(properties.getProperty("window.display.height"));
        FOV = (float) Math.toRadians(Float.valueOf(properties.getProperty("window.projection.fov")));
        NEAR = Float.valueOf(properties.getProperty("window.projection.near"));
        FAR = Float.valueOf(properties.getProperty("window.projection.far"));

        fb = BufferUtils.createFloatBuffer(16);

        this.projectionMatrix = new Matrix4f().setPerspective(FOV,(float)this.width/this.height,NEAR,FAR);
        init();
    }

    private void init() {
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        setHints();
        windowId = glfwCreateWindow(width, height, title, NULL, NULL);

        if (windowId == NULL) {
            throw new RuntimeException("Failed to create GLFW window");
        }

        glfwSetFramebufferSizeCallback(windowId, (window, width, height) -> {
            this.width = width;
            this.height = height;
            this.resized = true;
        });

        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            glfwGetWindowSize(windowId, pWidth, pHeight);

            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            glfwSetWindowPos(
                    windowId,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        }

        glfwMakeContextCurrent(windowId);

        if (vSync) {
            glfwSwapInterval(1);
        }

        glfwShowWindow(windowId);
        GL.createCapabilities();

        glClearColor(0f, 0f, 0f, 1.0f);
    }

    private void setHints() {
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);

    }

    public static Matrix4f updateProjectMatrix(Matrix4f matrix4f, int width, int height) {
        return matrix4f.setPerspective(FOV, (float) width / (float) height, NEAR, FAR);
    }

    public void destroy() {
        glfwFreeCallbacks(windowId);
        glfwDestroyWindow(windowId);

        glfwTerminate();
    }

    public void updateAfter() {
        glfwSwapBuffers(windowId);
        glfwPollEvents();
    }

    public boolean windowShouldClose() {
        return glfwWindowShouldClose(windowId);
    }

    public boolean isvSync() {
        return vSync;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight(){
        return height;
    }
}
