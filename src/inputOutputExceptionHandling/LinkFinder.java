package inputOutputExceptionHandling;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class LinkFinder {
	private String address;
	
	public LinkFinder(String addressURL){
		this.address = addressURL;
	}
	
	public ArrayList<String> findLink() throws IOException{
		URL u = new URL(this.address);
		Scanner in = new Scanner(u.openStream());
		ArrayList<String> links = new ArrayList<String>();
		while(in.hasNext()){
			String line = in.next();
			if(line.contains("href=\"")){
				// pull out the URL
				line = line.substring(6);
				line = line.substring(0, line.indexOf("\""));
				// check if it is valid
				try{
					URL test = new URL(line);
					links.add(line);
				}
				catch(MalformedURLException ue){
					System.out.print("This URL is malformed: ");
				}
				System.out.println(line);
				
			}
		}
		in.close();
		return links;
	}
}
