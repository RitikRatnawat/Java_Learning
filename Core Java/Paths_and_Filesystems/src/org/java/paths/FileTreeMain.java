package org.java.paths;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileTreeMain
{
    public static void main(String[] args)
    {
        System.out.println("------ Walking Tree for Dir2 ------");
        Path dir2Path = FileSystems.getDefault().getPath("Examples"+ File.separator +"Dir2");

        try
        {
            Files.walkFileTree(dir2Path, new PrintNames());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("------ Copying Dir2 to Dir4/Dir2Copy ------");
        Path copyPath = FileSystems.getDefault().getPath("Examples"+ File.separator +"Dir4"+ File.separator +"Dir2Copy");

        try
        {
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
