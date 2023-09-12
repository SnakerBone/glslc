package xyz.snaker.glslc.data;

/**
 * Created by SnakerBone on 8/09/2023
 **/
public enum VectorType implements ShaderDataType
{
    VEC2("vec2"),
    VEC3("vec3"),
    VEC4("vec4"),
    VEC2I("ivec2"),
    VEC3I("ivec3"),
    VEC4I("ivec4"),
    VEC2B("bvec2"),
    VEC3B("bvec3"),
    VEC4B("bvec4");

    private final String name;

    VectorType(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
