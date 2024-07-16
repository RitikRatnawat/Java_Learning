package org.java.paths;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class FileSystemMain
{
    public static void main(String[] args)
    {
        try
        {
//            // Copying Files
//            Path source = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path dest = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);

//            // Copying Directories
//            Path source = FileSystems.getDefault().getPath("Examples", "Dir1");
//            Path dest = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);

//            // Moving Files
//            Path source = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Path dest = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
//            Files.move(source, dest, StandardCopyOption.REPLACE_EXISTING);

//            // Renaming Files
//            Path source = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path dest = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Files.move(source, dest);

//            // Deleting Files
//            Path pathtoDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
//            Files.delete(pathtoDelete);
//            Files.deleteIfExists(pathtoDelete);

//            // Creating Files
//            Path createPath = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Files.createFile(createPath);

//            // Creating Directories
//            Path createDir = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.createDirectory(createDir);

            Path path = FileSystems.getDefault().getPath("Examples", "Dir1\\file1.txt");
//            long size = Files.size(path);
//            System.out.println(path.normalize().toAbsolutePath()+" - Size : "+size);
//            System.out.println("Last Modified Time : "+Files.getLastModifiedTime(path));

            BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("Size : "+attrs.size());
            System.out.println("Last Modified Time : "+attrs.lastModifiedTime());
            System.out.println("Created on : "+attrs.creationTime());
            System.out.println("Is Directory : "+attrs.isDirectory());
            System.out.println("Is Reguler File : "+attrs.isRegularFile());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
