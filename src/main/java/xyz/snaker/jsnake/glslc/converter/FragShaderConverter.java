package xyz.snaker.jsnake.glslc.converter;

import static xyz.snaker.jsnake.glslc.converter.ShaderComponents.V150;
import static xyz.snaker.jsnake.glslc.converter.ShaderComponents.V150F;

/**
 * Created by SnakerBone on 11/09/2023
 **/
public class FragShaderConverter
{
    public static String from120to150(String path, boolean prettyPrint)
    {
        ShaderModifier modifier = new ShaderModifier(path);
        ShaderComponents.applyDefaults120to150(modifier);
        modifier.replace(V150, V150F + "out vec4 fragColour;");
        modifier.replace("varying", "in");
        modifier.replace("gl_FragColor", "fragColour");
        modifier.replaceAll("precision.*", "");
        return modifier.build(prettyPrint);
    }
}
