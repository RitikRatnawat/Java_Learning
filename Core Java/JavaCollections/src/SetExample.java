import java.util.HashSet;
import java.util.Set;

public class SetExample
{
    public static void main(String[] args)
    {
        Set<String> keys = new HashSet<>();

        keys.add("Key1");
        keys.add("Key2");
        keys.add("Key3");
        keys.add("Key4");
        keys.add("Key5");
        keys.add("Key1");

        for(String key : keys)
            System.out.print(key + " ");
    }
}
