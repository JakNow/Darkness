package pl.oblivion.renderer.shaders.uniforms;

import org.joml.Quaternionf;
import org.joml.Vector3f;
import pl.oblivion.scene.light.Light;

abstract class UniformLight<T> extends Uniform {

    private UniformLightType lightType;
    private UniformVec3 position;
    private UniformQuaternion direction;
    private UniformVec4 color;
    private UniformAttenuation attenuation;
    private UniformFloat intensity;


    public UniformLight(String name, UniformLightType lightType) {
        super(name);
        this.position = new UniformVec3(name+".position");
        this.direction = new UniformQuaternion(name+".direction");
        this.color = new UniformVec4(name+".color");
        this.attenuation = new UniformAttenuation(name+".attenuation");
        this.intensity = new UniformFloat(name+".intensity");
    }

    public abstract void loadLight(T t);
}
