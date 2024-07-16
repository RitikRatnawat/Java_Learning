package com.javanio.allprograms.fromnioonly;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class CopyFIleswithThreadsinNIO
{
    public static void main(String[] args)
    {
        try(RandomAccessFile file = new RandomAccessFile("data2.dat", "rwd");
            FileChannel readChannel = file.getChannel();
            RandomAccessFile copyFile = new RandomAccessFile("data2copy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel())
        {
//            ByteBuffer input = ByteBuffer.allocate(1000);
//            readChannel.read(input);
//            readChannel.position(0);
//            long bytesTransferred = copyChannel.transferFrom(readChannel, 0, readChannel.size());
            long bytesTransferred = readChannel.transferTo(0, readChannel.size(), copyChannel);
            System.out.println("Bytes Transferred : "+bytesTransferred);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
