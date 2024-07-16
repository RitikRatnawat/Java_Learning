package com.javanio.allprograms.fromnioonly;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SeekableByteChannel
{
    public static void main(String[] args)
    {
        try(FileOutputStream binfile = new FileOutputStream("data.dat");
            FileChannel writeChannel = binfile.getChannel())
        {
//          // Writing to the File
            byte[] output = "Writing Binary Files with NIO".getBytes();
            long strPos1 = 0;
            long intPos1 = output.length;
            long intPos2 = intPos1 + Integer.BYTES;
            byte[] output2 = "Putting Integers with Offsets".getBytes();
            long strPos2 = intPos2 + Integer.BYTES;
            long intPos3 = strPos2 + output2.length;

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            writeChannel.position(intPos1);
            intBuffer.putInt(245);
            intBuffer.flip();
            System.out.println("Integer Bytes written : "+writeChannel.write(intBuffer));
            intBuffer.flip();

            writeChannel.position(intPos2);
            intBuffer.putInt(-36481);
            intBuffer.flip();
            System.out.println("Integer Bytes written : "+writeChannel.write(intBuffer));
            intBuffer.flip();

            writeChannel.position(intPos3);
            intBuffer.putInt(7532);
            intBuffer.flip();
            System.out.println("Integer Bytes written : "+writeChannel.write(intBuffer));

            writeChannel.position(strPos1);
            System.out.println("String Bytes written : "+writeChannel.write(ByteBuffer.wrap(output)));
            writeChannel.position(strPos2);
            System.out.println("String Bytes written : "+writeChannel.write(ByteBuffer.wrap(output2)));

//            ByteBuffer buffer = ByteBuffer.allocate(100);
//            byte[] output = "Writing Binary Files with NIO".getBytes();
//            buffer.put(output);
//            long intPos1 = output.length;
//            buffer.putInt(245);
//            long intPos2 = intPos1 + Integer.BYTES;
//            buffer.putInt(-32546);
//            byte[] output2 = "Putting Integers with Offsets".getBytes();
//            buffer.put(output2);
//            long intPos3 = intPos2 + Integer.BYTES + output2.length;
//            buffer.putInt(1000);
//            buffer.flip();


            // Reading from the File
            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel readChannel = ra.getChannel();
            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);

            readChannel.position(intPos3);
            readChannel.read(readBuffer);
            readBuffer.flip();
            System.out.println("Integer 3 : "+readBuffer.getInt());

            readBuffer.flip();
            readChannel.position(intPos2);
            readChannel.read(readBuffer);
            readBuffer.flip();
            System.out.println("Integer 2 : "+readBuffer.getInt());

            readBuffer.flip();
            readChannel.position(intPos1);
            readChannel.read(readBuffer);
            readBuffer.flip();
            System.out.println("Integer 1 : "+readBuffer.getInt());

//            ByteBuffer readBuffer = ByteBuffer.allocate(100);
//            readChannel.read(readBuffer);
//            readBuffer.flip();
//            byte[] input = new byte[output.length];
//            readBuffer.get(input);
//            System.out.println("Input 1 : "+new String(input));
//            readChannel.position(intPos3);
//            System.out.println("Integer 1 : "+readBuffer.getInt());
//            System.out.println("Integer 2 : "+readBuffer.getInt());
//            byte[] input2 = new byte[output2.length];
//            readBuffer.get(input2);
//            System.out.println("Input 2 : "+new String(input2));
//            System.out.println("Integer 3 : "+readBuffer.getInt());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
