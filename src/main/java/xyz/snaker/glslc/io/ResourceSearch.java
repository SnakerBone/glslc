package xyz.snaker.glslc.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiFunction;

/**
 * Created by SnakerBone on 12/09/2023
 **/
public class ResourceSearch
{
    private static final BiFunction<String, String, RuntimeException> INVALID_DIR = (dir, msg) -> new RuntimeException(String.format("Invalid Directory Path: '%s'. %s", dir, msg == null ? "" : msg));

    private final Path path;

    private final String directory;
    private final String fileName;

    public Path result;
    public boolean foundFile;

    public ResourceSearch(String pathToFile)
    {
        this.directory = checkPath(pathToFile).substring(0, pathToFile.indexOf('/') + 1);
        this.fileName = checkPath(pathToFile).substring(pathToFile.indexOf('/') + 1);
        this.path = Paths.get(ResourceIO.MAIN_RESOURCE_DIR + directory);
    }

    public ResourceSearch(String resourceDir, String pathToFile)
    {
        this.directory = checkPath(pathToFile).substring(0, pathToFile.indexOf('/') + 1);
        this.fileName = checkPath(pathToFile).substring(pathToFile.indexOf('/') + 1);
        this.path = Paths.get(resourceDir + directory);
    }

    private String checkPath(String path)
    {
        if (path == null) {
            throw new NullPointerException("Path cannot be null");
        }
        if (path.isEmpty()) {
            throw new RuntimeException("Path not specified properly");
        }
        if (path.indexOf('/') == -1) {
            throw INVALID_DIR.apply(path, null);
        }
        if (path.indexOf('.') != -1) {
            throw INVALID_DIR.apply(path, "Path cannot contain file extensions");
        }
        return path;
    }

    @Override
    public String toString()
    {
        walkFileTree(fileName);
        if (foundFile) {
            return result.toString();
        }
        throw new RuntimeException(String.format("Could not find file: %s", fileName));
    }

    public void walkFileTree(String fileName)
    {
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>()
            {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                {
                    String fn = file.getFileName().toString();
                    if (fn.substring(0, fn.indexOf('.')).equals(fileName)) {
                        ResourceSearch.this.foundFile = true;
                        ResourceSearch.this.result = file;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
