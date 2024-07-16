import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

public class ArrayListExample
{
    static ArrayList<String> listNames = new ArrayList<>();

    public static void main(String[] args)
    {
        listNames.add("First");
        listNames.add("Second");
        listNames.add("Third");
        listNames.add("Fourth");
        listNames.add("Fifth");
        listNames.add("Sixth");
        listNames.add("Seventh");
        listNames.add("Eighth");

        displayNames(listNames);
        removeNameByIndex(0);
        System.out.println();
        displayNames(listNames);
        removeNameByName("Sixth");
        System.out.println();
        displayNames(listNames);
        modifyName(4, "Sixth");
        System.out.println();
        displayNames(listNames);
        System.out.println();

        int indexOfThird = search(listNames, "Third");
        System.out.println("Index of \'Third\' : " + indexOfThird);
    }

    static void displayNames(ArrayList<String> names)
    {
        for(String name : names)
            System.out.print(name + " | ");
    }

    static void removeNameByIndex(int index)
    {
        listNames.remove(index);
    }

    static void removeNameByName(String name)
    {
        listNames.remove(name);
    }

    static void modifyName(int index, String newName)
    {
        listNames.set(index, newName);
    }

    static int search(ArrayList<String> names, String name)
    {
        return names.indexOf(name);
    }
}
