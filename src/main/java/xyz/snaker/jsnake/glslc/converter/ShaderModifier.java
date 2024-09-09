package xyz.snaker.jsnake.glslc.converter;

import java.util.function.Function;

import xyz.snaker.jsnake.glslc.io.ResourceIO;

/**
 * Created by SnakerBone on 11/09/2023
 **/
public class ShaderModifier
{
    private final Function<Integer, String> version = v -> "#version " + v;
    private String contents;

    public ShaderModifier(String path)
    {
        this.contents = ResourceIO.getShader(path);
    }

    private boolean hasVersion()
    {
        return contents.contains("#version");
    }

    private boolean hasExtension()
    {
        return contents.contains("#extension");
    }

    public ShaderModifier addVersion(int wanted, boolean lineBreaks)
    {
        contents = lineBreaks ? version.apply(wanted) + "\n\n" + contents : version.apply(wanted);
        return this;
    }

    public ShaderModifier replaceVersion(int current, int wanted, boolean lineBreaks)
    {
        if (!hasVersion()) {
            addVersion(wanted, lineBreaks);
        }
        contents = contents.replace(version.apply(current), version.apply(wanted));
        return this;
    }

    public ShaderModifier replaceExtension(String replacement)
    {
        if (!hasExtension()) {
            return this;
        }
        contents = contents.replaceAll("#extension.*", replacement);
        return this;
    }

    public ShaderModifier replace(String target, String replacement)
    {
        contents = contents.replace(target, replacement);
        return this;
    }

    public ShaderModifier replaceAll(String regex, String replacement)
    {
        contents = contents.replaceAll(regex, replacement);
        return this;
    }

    public String build(boolean prettyPrint)
    {
        if (prettyPrint) {
            contents = contents.replaceAll("(?m)^\\s*$[\n\r]+", "\n");
        } else {
            contents = contents.replaceAll("\n", " ");
            contents = contents.replaceAll("\\s+", " ");
        }
        return contents;
    }
}
