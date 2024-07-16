package com.javanio.allprograms.fromnioonly;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WritingUsingNIOonly
{
    public static void main(String[] args)
    {
        try
        {
//            FileInputStream file = new FileInputStream("student.txt");
//            FileChannel channel = file.getChannel();

            Path dataPath = FileSystems.getDefault().getPath("student.txt");

//            Files.write(dataPath,
//                    "Total Number of Students : 60".getBytes(StandardCharsets.UTF_8),
//                    StandardOpenOption.APPEND);

            Files.writeString(dataPath, "Total Number of Students : 60\n", StandardOpenOption.APPEND);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

}
