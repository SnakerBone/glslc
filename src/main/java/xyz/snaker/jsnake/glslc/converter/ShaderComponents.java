package xyz.snaker.jsnake.glslc.converter;

/**
 * Created by SnakerBone on 11/09/2023
 **/
public class ShaderComponents
{
    public static final String V120F = "#version 120\n\n";
    public static final String V150F = "#version 150\n\n";

    public static final String V120 = "#version 120";
    public static final String V150 = "#version 150";

    static void applyDefaults120to150(ShaderModifier modifier)
    {
        modifier.replaceVersion(120, 150, true);
        modifier.replaceExtension("\n");
    }
}
