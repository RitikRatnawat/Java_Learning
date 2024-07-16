public class Main
{
    public static void main(String[] args) {
        String str = "I am a String. Yes I am.";
        System.out.println(str);

        String yourString = str.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "ajd4doad5sfeed14fsl2";
        System.out.println(alphanumeric.replaceAll(".", "Y"));

        System.out.println(alphanumeric.replaceAll("^ajd", "Y"));

        System.out.println(alphanumeric.matches("^def"));
        System.out.println(alphanumeric.matches("^ajd"));

        System.out.println(alphanumeric.replaceAll("fsl2$", "THE END"));
        System.out.println(alphanumeric.replaceAll("[aeiou]", "V"));
        System.out.println(alphanumeric.replaceAll("[aeiou][dj]", "V"));

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        String alpha2 = "abcccdeeABe456DFdaffltdsghj";
        System.out.println(alpha2.replaceAll("[^cef]", "X"));
        System.out.println(alpha2.replaceAll("[a-f]", "X"));
        System.out.println(alpha2.replaceAll("(?i)[a-f]", "X"));
        System.out.println(alpha2.replaceAll("[0-9]", "X"));
        System.out.println(alpha2.replaceAll("\\d", "X"));
        System.out.println(alpha2.replaceAll("\\D", "X"));

        String whitespace = "I have spaces \t a tab, and a newline \n";
        System.out.println(whitespace);
        System.out.println(whitespace.replaceAll("\\s", ""));
        System.out.println(whitespace.replaceAll("\t", ""));
        System.out.println(whitespace.replaceAll("\\S", ""));

        String alpha3 = "sfbksdg1fgs25 4ds23465+fgksdf5265";
        System.out.println(alpha3.replaceAll("\\w", "x"));
        System.out.println(alpha3.replaceAll("\\W", " x "));
        System.out.println(alpha3.replaceAll("\\b", "_"));


        String string = "abcdeeembt1485smcliiiam";
        System.out.println(string.replaceAll("^abcde{3}", "REPLACED"));
        System.out.println(string.replaceAll("^abcde+", "REPLACED"));
        System.out.println(string.replaceAll("^abcde*", "REPLACED"));
        System.out.println(string.replaceAll("^abcde{2,5}", "REPLACED"));
        System.out.println(string.replaceAll("m+b*t", "REPLACED"));
    }
}
