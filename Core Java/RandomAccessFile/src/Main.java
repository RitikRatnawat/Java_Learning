import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main
{
    public static void main(String[] args)
    {
        try(RandomAccessFile random = new RandomAccessFile("studentData.dat", "rwd"))
        {
            for(int i = 303001, j = 1; i <= 303060; i++, j++)
            {
                random.writeInt(i);
                String id = String.format("%02d", j);
                random.writeUTF(", Student"+id);
            }

            int start = 0;
            boolean eof = false;
            try
            {
                while (!eof)
                {
                    random.seek(start);
                    int id = (int) random.readInt();
                    String name = random.readUTF();
                    System.out.println(id + " " + name);
                    int length = (int) random.getFilePointer() - start;
                    System.out.println(length);
                    start = (int) random.getFilePointer() + length;
                    System.out.println(start);
                }
            }
            catch(EOFException e)
            {
                eof = true;
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
