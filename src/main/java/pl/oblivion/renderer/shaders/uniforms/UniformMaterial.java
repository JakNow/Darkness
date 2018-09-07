package pl.oblivion.renderer.shaders.uniforms;

import lombok.Getter;
import pl.oblivion.scene.material.Material;

@Getter
public class UniformMaterial extends Uniform {

    private final UniformBoolean hasDiffuseTexture;
    private final UniformBoolean hasNormalTexture;
    private final UniformBoolean hasAmbientTexture;
    private final UniformBoolean hasSpecularTexture;
    private final UniformBoolean hasAlphaTexture;

    private final UniformVec4 ambientColor;
    private final UniformVec4 diffuseColor;
    private final UniformVec4 specularColor;
    private final UniformVec4 emissiveColor;
    private final UniformVec4 reflectiveColor;

    private final UniformFloat reflectivity;
    private final UniformFloat shininess;

    public UniformMaterial(String name) {
        super(name);

        this.hasDiffuseTexture = new UniformBoolean(name+".hasDiffuseTexture");
        this.hasNormalTexture = new UniformBoolean(name+".hasNormalTexture");
        this.hasAmbientTexture = new UniformBoolean(name+".hasAmbientTexture");
        this.hasSpecularTexture = new UniformBoolean(name+".hasSpecularTexture");
        this.hasAlphaTexture = new UniformBoolean(name+".hasAlphaTexture");

        this.ambientColor = new UniformVec4(name+".ambientColor");
        this.diffuseColor = new UniformVec4(name+".diffuseColor");
        this.specularColor = new UniformVec4(name+".specularColor");
        this.emissiveColor = new UniformVec4(name+".emissiveColor");
        this.reflectiveColor = new UniformVec4(name+".reflectiveColor");

        this.reflectivity = new UniformFloat(name+".reflectivity");
        this.shininess = new UniformFloat(name+".shininess");
    }

    @Override
    public void storeUniformLocation(int programId){
        this.hasDiffuseTexture.storeUniformLocation(programId);
        this.hasNormalTexture.storeUniformLocation(programId);
        this.hasAmbientTexture.storeUniformLocation(programId);
        this.hasSpecularTexture.storeUniformLocation(programId);
        this.hasAlphaTexture.storeUniformLocation(programId);

        this.ambientColor.storeUniformLocation(programId);
        this.diffuseColor.storeUniformLocation(programId);
        this.specularColor.storeUniformLocation(programId);
        this.emissiveColor.storeUniformLocation(programId);
        this.reflectiveColor.storeUniformLocation(programId);

        this.reflectivity.storeUniformLocation(programId);
        this.shininess.storeUniformLocation(programId);
    }

    public void loadMaterial(Material material){
        this.hasDiffuseTexture.loadBoolean(material.isUseDiffuseTexture());
        this.hasNormalTexture.loadBoolean(material.isUseNormalTexture());
        this.hasAmbientTexture.loadBoolean(material.isUseAmbientTexture());
        this.hasSpecularTexture.loadBoolean(material.isUseSpecularTexture());
        this.hasAlphaTexture.loadBoolean(material.isUseAlphaTexture());

        this.ambientColor.loadVec4(material.getAmbientColor());
        this.diffuseColor.loadVec4(material.getDiffuseColor());
        this.specularColor.loadVec4(material.getSpecularColor());
        this.emissiveColor.loadVec4(material.getEmissiveColor());
        this.reflectiveColor.loadVec4(material.getReflectiveColor());

        this.reflectivity.loadFloat(material.getReflectivity());
        this.shininess.loadFloat(material.getShininess());
    }
}
