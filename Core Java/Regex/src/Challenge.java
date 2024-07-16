public class Challenge
{
    public static void main(String[] args)
    {
        // Challenge 1
        String challenge1 = "I want a bike.";
        System.out.println("Challenge 1 : "+challenge1.matches(".+"));
        System.out.println("Challenge 1 : "+challenge1.matches("I want a bike."));

        System.out.println("----------------------------------------");

        // Challenge 2
        String str1 = "I want a bike.";
        String str2 = "I want a ball.";
        System.out.println("Challenge 2 : "+str1.matches("I want a \\w+."));
        System.out.println("Challenge 2 : "+str2.matches("I want a \\w+."));
        System.out.println("Challenge 2 : "+str1.matches("I want a (bike|ball)."));
        System.out.println("Challenge 2 : "+str2.matches("I want a (bike|ball)."));

        System.out.println("----------------------------------------");

        // Challenge 7
        String str3 = "abcd.135";
        System.out.println(str3.matches("^[A-z][a-z]+\\.\\d+$"));

    }
}
