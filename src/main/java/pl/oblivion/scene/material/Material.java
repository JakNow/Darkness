package pl.oblivion.scene.material;

import lombok.Getter;
import lombok.Setter;
import org.joml.Vector4f;

@Getter
@Setter
public abstract class Material {

    private boolean useDiffuseTexture = false;
    private boolean useNormalTexture = false;
    private boolean useAmbientTexture = false;
    private boolean useSpecularTexture = false;
    private boolean useAlphaTexture = false;

    private Vector4f ambientColor;
    private Vector4f diffuseColor;
    private Vector4f specularColor;
    private Vector4f emissiveColor;
    private Vector4f reflectiveColor;

    private float reflectivity;
    private float shininess;

}
