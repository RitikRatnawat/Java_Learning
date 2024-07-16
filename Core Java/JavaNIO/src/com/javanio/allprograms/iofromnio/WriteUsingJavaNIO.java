package com.javanio.allprograms.iofromnio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteUsingJavaNIO
{
    public static void main(String[] args)
    {
        Path sdLoc = FileSystems.getDefault().getPath("student.txt");

        try(BufferedWriter bw = Files.newBufferedWriter(sdLoc))
        {
            for(int i = 1; i <= 60; i++)
            {
                String no = String.format("%02d", i);
                System.out.print(no+". Student"+no+"\n");
                bw.write(no+". Student"+no+"\n");
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
