package xyz.snaker.glslc.io;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SnakerBone on 14/09/2023
 **/
public class DirectoryIO
{
    public static List<String> getModules()
    {
        List<String> modulePaths = new ArrayList<>();
        String[] modules = Paths.get("src").toFile().list();
        if (modules != null) {
            List<String> paths = Arrays.asList(modules);
            modulePaths.addAll(paths);
        }
        return modulePaths;
    }
}
