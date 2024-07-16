import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            URI baseUri = new URI("http://username:password@myserver.com:5000");
            URI uri = new URI("/catalogue/phones?os=android#samsung");
            URI resolvedURI = baseUri.resolve(uri);

            URL url = resolvedURI.toURL();
            System.out.println("URL : "+url);

            System.out.println("URI Scheme : " + uri.getScheme());
            System.out.println("URI Scheme-Specific-Part : " + uri.getSchemeSpecificPart());
            System.out.println("URI Authority : " + uri.getAuthority());
            System.out.println("URI User Info : " + uri.getUserInfo());
            System.out.println("URI Host : " + uri.getHost());
            System.out.println("URI Port : " + uri.getPort());
            System.out.println("URI Query : " + uri.getQuery());
            System.out.println("URI Fragment : " + uri.getFragment());
        }
        catch(URISyntaxException e)
        {
            System.out.println("URI Syntax Exception : "+e.getMessage());
        }
        catch(MalformedURLException e)
        {
            System.out.println("MalformedURLException : "+e.getMessage());
        }
    }
}