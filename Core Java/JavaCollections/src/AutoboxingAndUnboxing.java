import java.util.ArrayList;

public class AutoboxingAndUnboxing
{
    public static void main(String[] args)
    {
        Integer i1 = 26;    // Autoboxing
        Integer i2 = Integer.valueOf(50);

        int i3 = i1; // Unboxing
        int i4 = i2.intValue();

        System.out.println(i3);
        System.out.println(i4);
    }
}
