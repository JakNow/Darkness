package pl.oblivion.renderer.shaders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import pl.oblivion.renderer.shaders.uniforms.Uniform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

abstract class ShaderProgram {

    private static Logger logger;
    private final ShaderType type;
    private int shaderProgramId;


    ShaderProgram(ShaderType type, String vertexFilePath, String fragmentFilePath, String... inVariables) {
        logger = initLogger();
        this.type = type;
        initShader(vertexFilePath, fragmentFilePath, inVariables);
    }

    private Logger initLogger() {
        return LogManager.getLogger(this.getClass().getName());
    }

    private void initShader(String vertexFilePath, String fragmentFilePath, String... inVariables) {
        logger.info("Creating a new shader program for {}.", this.getClass().getName());
        int vertexShaderId = loadShader(vertexFilePath, GL20.GL_VERTEX_SHADER);
        int fragmentShaderId = loadShader(fragmentFilePath, GL20.GL_FRAGMENT_SHADER);
        shaderProgramId = GL20.glCreateProgram();
        GL20.glAttachShader(shaderProgramId, vertexShaderId);
        GL20.glAttachShader(shaderProgramId, fragmentShaderId);
        bindAttributes(inVariables);
        GL20.glLinkProgram(shaderProgramId);
        GL20.glDetachShader(shaderProgramId, vertexShaderId);
        GL20.glDetachShader(shaderProgramId, fragmentShaderId);
        GL20.glDeleteShader(vertexShaderId);
        GL20.glDeleteShader(fragmentShaderId);
    }

    private int loadShader(String filePath, int type) {
        StringBuilder shaderSources = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(filePath))))) {
            br.lines().forEach(line -> shaderSources.append(line).append("\\/n"));
        } catch (IOException e) {
            logger.error("Couldn't read file {}", filePath);
        }
        int shaderId = GL20.glCreateShader(type);
        GL20.glShaderSource(shaderId, shaderSources);
        GL20.glCompileShader(shaderId);
        if (GL20.glGetShaderi(shaderId, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
            logger.error("Couldn't compile shader {}.", filePath);
            logger.error(GL20.glGetShaderInfoLog(shaderId, 500));
            clear();
            System.exit(-1);
        }
        logger.info("Compiled shader {}.", filePath);
        return shaderId;
    }

    private void bindAttributes(String... inVariables) {
        for (int i = 0; i < inVariables.length; i++) {
            GL20.glBindAttribLocation(shaderProgramId, i, inVariables[i]);
        }
    }

    private void clear() {
        stop();
        logger.info("Clearing shader program {}", shaderProgramId);
        GL20.glDeleteProgram(shaderProgramId);
    }

    private void stop() {
        GL20.glUseProgram(0);
    }

    private void start() {
        GL20.glUseProgram(shaderProgramId);
    }

    void storeAllUniformLocations(Uniform... uniforms) {
        for (Uniform uniform : uniforms) {
            uniform.storeUniformLocation(shaderProgramId);
        }
        GL20.glValidateProgram(shaderProgramId);
    }

}
