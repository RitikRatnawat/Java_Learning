import java.util.LinkedList;

public class LinkedListExample
{
    public static void main(String[] args)
    {
        LinkedList<String> countries = new LinkedList<>();

        countries.add("India");
        countries.add("America");
        countries.add("Australia");
        countries.add("Russia");
        countries.add("Egypt");
        countries.add("China");
        countries.add("Africa");
        displayLinkedList(countries);
        countries.add(5, "Nepal");
        System.out.println();
        displayLinkedList(countries);
        countries.set(6, "Canada");
        System.out.println();
        displayLinkedList(countries);
        countries.remove(4);
        System.out.println();
        displayLinkedList(countries);
    }

    static void displayLinkedList(LinkedList<String> list)
    {
        for(String country : list)
            System.out.print(country + " -> ");
    }
}
