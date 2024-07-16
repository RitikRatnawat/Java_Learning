package com.javanio.allprograms.fromnioonly;

import java.awt.image.renderable.RenderableImageProducer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;

public class PipesWithThreads
{
    public static void main(String[] args)
    {
        try
        {
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable() {
                @Override
                public void run()
                {
                    try
                    {
                        Pipe.SinkChannel sink = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(50);

                        for(int i = 0; i < 10; i++)
                        {
                            String time = "The Time is : "+System.currentTimeMillis();
                            System.out.println("Writer Thread : "+time);
                            buffer.put(time.getBytes());
                            buffer.flip();

                            while(buffer.hasRemaining())
                            {
                                sink.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run()
                {
                    try
                    {
                        Pipe.SourceChannel source = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(50);

                        for(int i = 0; i < 10; i++)
                        {
                            int byteRead = source.read(buffer);
                            byte[] input = new byte[byteRead];
                            buffer.flip();
                            buffer.get(input);
                            System.out.println("Reader Thread : "+new String(input));
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
