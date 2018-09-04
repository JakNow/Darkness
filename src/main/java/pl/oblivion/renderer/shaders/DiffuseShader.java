package pl.oblivion.renderer.shaders;

public class DiffuseShader extends ShaderProgram {

    private static final String vertexFile = "shaders/diffuse/vertex.vert";
    private static final String fragmentFile = "shaders/diffuse/fragment.frag";

    DiffuseShader() {
        super(ShaderType.Diffuse, vertexFile, fragmentFile, "in_position", "in_texture", "in_normal");
        super.storeAllUniformLocations();
    }
}
