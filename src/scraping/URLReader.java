package scraping;

import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {

        URL dracula = new URL("http://www.gutenberg.org/cache/epub/345/pg345.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(dracula.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
