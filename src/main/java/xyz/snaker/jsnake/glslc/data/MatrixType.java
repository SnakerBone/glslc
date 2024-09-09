package xyz.snaker.jsnake.glslc.data;

/**
 * Created by SnakerBone on 8/09/2023
 **/
public enum MatrixType implements ShaderDataType
{
    MATRIX2X2("mat2"),
    MATRIX3X3("mat3"),
    MATRIX4X4("mat4");

    private final String name;

    MatrixType(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
