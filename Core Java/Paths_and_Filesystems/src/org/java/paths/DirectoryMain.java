package org.java.paths;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class DirectoryMain
{
    public static void main(String[] args)
    {
//        Path directory = FileSystems.getDefault().getPath("Examples/Dir2");
//        Path directory = FileSystems.getDefault().getPath("Examples"+File.separator+"Dir2");

//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
//            @Override
//            public boolean accept(Path entry) throws IOException {
//                return (Files.isRegularFile(entry));
//            }
//        };

//        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);
//
//        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter))
//        {
//            for(Path filePath : contents)
//            {
//                System.out.println(filePath.getFileName());
//            }
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }

//        String separator = File.separator;
//        System.out.println(separator);
//        separator = FileSystems.getDefault().getSeparator();
//        System.out.println(separator);

//        try
//        {
//            Path tempFile = Files.createTempFile("mytemp",".appext");
//            System.out.println("Temporary File Path : "+tempFile.toAbsolutePath());
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
//
//        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
//
//        for(FileStore store : stores)
//        {
//            System.out.println(store);
//            System.out.println(store.name());
//        }

        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for(Path path : rootPaths)
        {
            System.out.println(path);
        }
    }
}
