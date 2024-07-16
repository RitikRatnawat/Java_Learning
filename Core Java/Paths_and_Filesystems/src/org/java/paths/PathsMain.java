package org.java.paths;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsMain
{
    public static void main(String[] args)
    {
        Path path1 = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path1);
        System.out.println();

//        Path path2 = FileSystems.getDefault().getPath("Files","SubDirectoryFile.txt");
        Path path2 = Paths.get(".","Files", "..", "Files", "SubDirectoryFile.txt");
        printFile(path2);
        System.out.println(path2.normalize().toAbsolutePath());
        System.out.println();

        Path path3 = Paths.get("D:\\My Learning\\Java Practice","Java Masterclass Course Programs", "OutProject.txt");
        printFile(path3);
        System.out.println();

        Path path4 = Paths.get(".");
        System.out.println(path4.toAbsolutePath());

        Path path5 = FileSystems.getDefault().getPath("temp.txt");
        System.out.println("Is File exists at path1 : "+ Files.exists(path1));
        System.out.println("Is File writable at path1 : "+ Files.isWritable(path1));
        System.out.println("Is File readable at path1 : "+ Files.isReadable(path1));
        System.out.println("Is File exists at path5 : "+ Files.exists(path5));
        System.out.println("Is File writable at path5 : "+ Files.isWritable(path5));
        System.out.println("Is File readable at path5 : "+ Files.isReadable(path5));
    }

    private static void printFile(Path path)
    {
        try(BufferedReader reader = Files.newBufferedReader(path))
        {
            String line;

            while((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
