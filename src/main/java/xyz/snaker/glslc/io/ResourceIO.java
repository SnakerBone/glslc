package xyz.snaker.glslc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by SnakerBone on 10/09/2023
 **/
public class ResourceIO
{
    public static final String RESOURCES_DIRECTORY = "src/main/resources/";

    public static String getShader(String path)
    {
        String filePath = new ResourceSearch(path).toString();
        File file = new File(filePath);
        BufferedReader reader = safeCreate(file);
        return safeRead(reader);
    }

    static String safeRead(BufferedReader reader)
    {
        try {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append('\n');
            }
            reader.close();
            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static BufferedReader safeCreate(File file)
    {
        try {
            FileReader reader = new FileReader(file);
            return new BufferedReader(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
