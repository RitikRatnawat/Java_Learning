package com.javanio.allprograms.fromnioonly;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadingUsingNIOonly
{
    public static void main(String[] args)
    {
        try
        {
//            FileInputStream file = new FileInputStream("student.txt");
//            FileChannel channel = file.getChannel();

            Path dataPath = FileSystems.getDefault().getPath("student.txt");
            List<String> lines = Files.readAllLines(dataPath);

            for(String line : lines)
            {
                System.out.println(line);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

}
