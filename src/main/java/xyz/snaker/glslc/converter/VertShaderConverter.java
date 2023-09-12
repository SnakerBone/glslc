package xyz.snaker.glslc.converter;

/**
 * Created by SnakerBone on 11/09/2023
 **/
public class VertShaderConverter
{
    public static String from120to150(String path, boolean prettyPrint)
    {
        ShaderModifier modifier = new ShaderModifier(path);
        ShaderComponents.applyDefaults120to150(modifier);
        modifier.replace("varying", "in");
        return modifier.build(prettyPrint);
    }
}
