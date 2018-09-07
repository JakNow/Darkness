package pl.oblivion.renderer.shaders.uniforms;

public class UniformLightArray extends Uniform {

    private final UniformLight[] uniformLights;

    public UniformLightArray(String name, int size) {
        super(name);
        uniformLights = new UniformLight[size];
    }
}
