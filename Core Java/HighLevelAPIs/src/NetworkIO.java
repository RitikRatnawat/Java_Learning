import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class NetworkIO
{
    public static void main(String[] args)
    {
        try
        {
            URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=dogs");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(30000);

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code : "+responseCode);

            if(responseCode != 200)
            {
                System.out.println("Error Reading Page");
                System.out.println(connection.getResponseMessage());
                return;
            }

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line;
            while((line = inputReader.readLine()) != null)
            {
                System.out.println(line);
            }

//            urlConnection.setDoOutput(true);
//            urlConnection.connect();
//
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(urlConnection.getInputStream())
//            );
//
//            Map<String, List<String>> headers = urlConnection.getHeaderFields();
//
//            for(Map.Entry<String, List<String>> entry : headers.entrySet())
//            {
//                String key = entry.getKey();
//                List<String> value = entry.getValue();
//
//                System.out.println("Key : "+key);
//                for(String val : value)
//                    System.out.println("Value : "+val);
//            }

//            String line = "";
//            while(line != null)
//            {
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//
//            inputStream.close();
        }
        catch(MalformedURLException e)
        {
            System.out.println("URL malformed : "+e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("IOException : " + e.getMessage());
        }
    }
}