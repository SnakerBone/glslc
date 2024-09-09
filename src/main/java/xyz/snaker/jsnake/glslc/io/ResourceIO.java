package xyz.snaker.jsnake.glslc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

/**
 * Created by SnakerBone on 10/09/2023
 **/
public class ResourceIO
{
    public static final Function<String, String> CUSTOM_RESOURCE_DIR = path -> "src/" + path + "/resources/";

    public static final String MAIN_RESOURCE_DIR = "src/main/resources/";
    public static final String TEST_RESOURCE_DIR = "src/test/resources/";

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
