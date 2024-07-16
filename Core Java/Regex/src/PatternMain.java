import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMain
{
    public static void main(String[] args)
    {
        StringBuilder html = new StringBuilder("<h1>H1 Heading</h1>");
        html.append("<h2>H2 Heading</h2>");
        html.append("<p>This is a Paragraph 1</p>");
        html.append("<p>This is a Paragraph 2</p>");
        html.append("<h2>Summary</h2>");
        html.append("<p>This is a Summary</p>");

        String h2pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2pattern);
        Matcher matcher = pattern.matcher(html);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while(matcher.find())
        {
            count++;
            System.out.println("Occurrence "+count+" : "+matcher.start()+" to "+matcher.end());
        }

        System.out.println("-------------------------------------");

        String h2group = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2group);
        Matcher groupMatcher = groupPattern.matcher(html);
        System.out.println(groupMatcher.matches());

        matcher.reset();

        while (groupMatcher.find())
        {
            System.out.println("Occurrence "+groupMatcher.group(1));
        }

        System.out.println("-------------------------------------");

        String group = "(<h2>)(.+?)(</h2>)";
        Pattern grpPattern = Pattern.compile(group);
        Matcher grpMatcher = grpPattern.matcher(html);

        while(grpMatcher.find())
        {
            System.out.println("Occurrence : "+grpMatcher.group(2));
        }

        System.out.println("-------------------------------------");

        // Validating US Phone Number
        String regex = "^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})";
        String phone1 = "1234567890";
        String phone2 = "(123) 456-7890";

        System.out.println("Phone 1 : "+phone1.matches(regex));
        System.out.println("Phone 2 : "+phone2.matches(regex));

        System.out.println("-------------------------------------");

        // Validating VISA Card number
        regex = "^4[0-9]{12}([0-9]{3})?$";
        String card1 = "4444444444444444";
        String card2 = "5444444444444444";

        System.out.println("Card 1 : "+card1.matches(regex));
        System.out.println("Card 2 : "+card2.matches(regex));
    }
}
