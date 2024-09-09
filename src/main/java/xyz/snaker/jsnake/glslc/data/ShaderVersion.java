package xyz.snaker.jsnake.glslc.data;

/**
 * Created by SnakerBone on 8/09/2023
 **/
public enum ShaderVersion
{
    V120(120),
    V150(150);

    private final long version;

    ShaderVersion(long version)
    {
        this.version = version;
    }

    public long get()
    {
        return version;
    }
}
