package com.javanio.allprograms.fromnioonly;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WritingBinaryFiles
{
    public static void main(String[] args)
    {
        try(FileOutputStream binfile = new FileOutputStream("data.dat");
            FileChannel channel = binfile.getChannel())
        {
            byte[] output = "Writing Binary Files with NIO".getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(output.length);
            buffer.put(output);

            buffer.flip();
            int charCount = channel.write(buffer);
            System.out.println("Number of Bytes written : "+charCount);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            charCount = channel.write(intBuffer);
            System.out.println("Number of Interger Bytes written : "+charCount);

            intBuffer.flip();
            intBuffer.putInt(-32158);
            intBuffer.flip();
            charCount = channel.write(intBuffer);
            System.out.println("Number of Interger Bytes written : "+charCount);


        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
