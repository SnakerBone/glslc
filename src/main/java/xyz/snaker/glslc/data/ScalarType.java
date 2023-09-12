package xyz.snaker.glslc.data;

/**
 * Created by SnakerBone on 8/09/2023
 **/
public enum ScalarType implements ShaderDataType
{
    INT("int"),
    FLOAT("float"),
    BOOLEAN("bool"),
    VOID("void");

    private final String name;

    ScalarType(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
