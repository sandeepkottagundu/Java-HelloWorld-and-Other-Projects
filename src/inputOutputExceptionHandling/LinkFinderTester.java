package inputOutputExceptionHandling;

import java.io.IOException;
import java.util.ArrayList;

public class LinkFinderTester {

	public static void main(String[] args) {
		LinkFinder lf = new LinkFinder("http://google.com");
		try {
			ArrayList<String> validLinks = lf.findLink();
			for(String link : validLinks){
				// breadth first search going 1 layer deep
				LinkFinder l = new LinkFinder(link);
				l.findLink();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
