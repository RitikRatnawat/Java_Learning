package com.javanio.allprograms.fromnioonly;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadingBinaryFiles
{
    public static void main(String[] args)
    {
        try(RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel())
        {

            byte[] input = new byte[29];
            ByteBuffer buffer = ByteBuffer.wrap(input);
            long bytesRead = channel.read(buffer);

            System.out.println(new String(input));
            System.out.println("Number of Bytes readed : "+bytesRead);

            // Absolute Read
            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            bytesRead = channel.read(intBuffer);
            intBuffer.flip();

            System.out.println(intBuffer.getInt(0));
            System.out.println("Number of Bytes read : "+bytesRead);

            bytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt(0));
            System.out.println("Number of Bytes read : "+bytesRead);




            // Relative Read
                //  ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
                //  bytesRead = channel.read(intBuffer);
                //  intBuffer.flip();
                //  System.out.println((intBuffer.getInt()));
                //  System.out.println("Number of Bytes readed : "+bytesRead);
                //
                //  intBuffer.flip();
                //  bytesRead = channel.read(intBuffer);
                //  intBuffer.flip();
                //  System.out.println((intBuffer.getInt()));
                //  System.out.println("Number of Bytes readed : "+bytesRead);

            // Reading using IO package
                //   RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
                //   byte[] b = new byte[29];
                //   ra.read(b);
                //   System.out.println(new String(b));
                //
                //   long int1 = ra.readInt();
                //   long int2 = ra.readInt();
                //
                //   System.out.println(int1);
                //   System.out.println(int2);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
