

import org.jsoup.nodes.Document;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by dev on 08/03/2017.
 */
public class JsoupYoutube {

    public static void main(String[] args) throws Exception {
        URL myURL = new URL("https://www.wikipedia.org/wiki/Pulp_Fiction");
        myURL.openStream();
        URLConnection myURLConnection = myURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) myURLConnection;
        httpURLConnection.setInstanceFollowRedirects(false);
        String location = httpURLConnection.getHeaderField("location");
        StringBuilder html = new StringBuilder();
        System.out.println(location);
        myURL = new URL(location);
        myURLConnection = myURL.openConnection();

        InputStreamReader in = new InputStreamReader(myURLConnection.getInputStream());
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextLine()) {
            html.append(scanner.nextLine());
        }
        Document page = org.jsoup.Jsoup.parse(html.toString());

        System.out.println(page);
        System.out.println(page.getElementById("plainlist"));


    }
}
