package pl.oblivion.renderer.shaders.uniforms;

import pl.oblivion.scene.light.Attenuation;

public class UniformAttenuation extends Uniform {

    private UniformFloat constant;
    private UniformFloat linear;
    private UniformFloat exponent;

    public UniformAttenuation(String name) {
        super(name);
        this.constant = new UniformFloat(name+".constant");
        this.linear = new UniformFloat(name+".linear");
        this.exponent = new UniformFloat(name+".exponent");
    }

    private void loadAttenuation(Attenuation attenuation){
        this.constant.loadFloat(attenuation.getConstant());
        this.linear.loadFloat(attenuation.getLinear());
        this.exponent.loadFloat(attenuation.getExponent());
    }
}
