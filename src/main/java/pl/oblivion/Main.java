package pl.oblivion;

import pl.oblivion.utils.AppConfig;
import pl.oblivion.utils.Timer;
import pl.oblivion.window.Window;

import java.util.Properties;

import static org.lwjgl.opengl.GL11.glViewport;

public class Main {

    private Properties properties = AppConfig.loadProperties("src/main/resources/app.properties");
    private final int ups = Integer.parseInt(properties.getProperty("window.display.ups"));
    private final int fps = Integer.parseInt(properties.getProperty("window.display.fps"));
    private Window window;
    private Timer timer;

    private Main() {
        window = new Window(properties);
        timer = new Timer();
    }

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        init();
        float elapsedTime;
        float accumulator = 0f;
        float interval = 1f / ups;

        while (!window.windowShouldClose()) {
            glViewport(0,0,window.getWidth(), window.getHeight());
            elapsedTime = timer.getElapsedTime();
            accumulator += elapsedTime;

            while (accumulator >= interval) {
                logicUpdate();
                accumulator -= interval;
            }

            renderUpdate();
            if (!window.isvSync()) {
                sync();
            }
            window.updateAfter();
        }

        cleanUp();
        window.destroy();
    }

    private void init() {
        //todo init all rendering stuff eg. renderer, shader, scene loaders, etc;
    }

    private void logicUpdate() {
        //todo logic update
    }

    private void renderUpdate() {
        //todo render update
    }

    private void sync() {
        float loopSlot = 1f / fps;
        double endTime = timer.getLastLoopTime() + loopSlot;

        while (timer.getTime() < endTime) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    private void cleanUp() {
        //todo clean renderer
    }
}
