package xyz.snaker.glslc.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by SnakerBone on 12/09/2023
 **/
public class ResourceSearch
{
    private final Path path;

    private final String directory;
    private final String fileName;

    private Path result;
    private boolean foundFile;

    public ResourceSearch(String pathToFile)
    {
        this.directory = pathToFile.substring(0, pathToFile.indexOf('/') + 1);
        this.fileName = pathToFile.substring(pathToFile.indexOf('/') + 1);
        this.path = Paths.get(ResourceIO.RESOURCES_DIRECTORY + directory);
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

    private void walkFileTree(String fileName)
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
