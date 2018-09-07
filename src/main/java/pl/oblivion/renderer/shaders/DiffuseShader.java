package pl.oblivion.renderer.shaders;

import org.joml.Matrix4f;
import pl.oblivion.renderer.Renderer;
import pl.oblivion.renderer.shaders.uniforms.*;

import java.util.Properties;

public class DiffuseShader extends ShaderProgram {

    private static final String vertexFile = "shaders/diffuse/vertex.vert";
    private static final String fragmentFile = "shaders/diffuse/fragment.frag";

    private final int maxLights;

    private final UniformMat4 projectionMatrix = new UniformMat4("projectionMatrix");
    private final UniformMat4 modelViewMatrix = new UniformMat4("modelViewMatrix");
    private final UniformInt nuLights = new UniformInt("numberOfLights");

    private final UniformAmbientLight ambientLight = new UniformAmbientLight("ambientLight");
    private final UniformMaterial material = new UniformMaterial("material");
    private final UniformLightArray lightArray;

    private final UniformSampler diffuseTexture = new UniformSampler("diffuseTexture");
    private final UniformSampler normalTexture = new UniformSampler("normalTexture");
    private final UniformSampler ambientTexture = new UniformSampler("ambientTexture");
    private final UniformSampler specularTexture = new UniformSampler("specularTexture");
    private final UniformSampler alphaTexture = new UniformSampler("alphaTexture");


    DiffuseShader(Properties properties) {
        super(ShaderType.Diffuse, vertexFile, fragmentFile, properties,"in_position", "in_texture", "in_normal");
        this.maxLights = Integer.valueOf(properties.getProperty("shader.lights.max"));
        lightArray = new UniformLightArray("light",this.maxLights);
        super.storeAllUniformLocations();
    }

    @Override
    public void loadUniformOnce(Renderer renderer) {

    }

    @Override
    public void startShaderRenderLogic(Renderer renderer, Matrix4f viewMatrix) {

    }

    @Override
    public void prepareMeshUniforms(Object... objects) {

    }

    @Override
    public void prepareModelUniforms(Object... objects) {

    }

    @Override
    public void stopShaderRenderLogic() {

    }

    @Override
    public void connectTextureUnits() {

    }
}
