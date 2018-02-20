package scraping;

import java.net.*;
import java.io.*;

public class BookToHTML {

	public static void main(String[] args) throws Exception{
		URL dracula = new URL("http://www.gutenberg.org/cache/epub/345/pg345.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(dracula.openStream()));

        String inputLine;
        
        BookParser bp = new BookParser();
        String book = ""; 
        boolean wasEmptyLine = false;
        boolean wasReturn = false;
        boolean wasParagraph = false;
 
        while ((inputLine = in.readLine()) != null){
        	String s = inputLine;
        	wasEmptyLine = s.equals("");
        	if(wasEmptyLine){
        		if(wasParagraph){
        			book += "</p>\n";
        		}
        		book += "<br>\n";
        	}
        	else{
        		if(!wasEmptyLine || !wasReturn){
        			//replace special characters first since it will mess up html tags
        			s = bp.replaceSpecialCharacters(s);
                	if(bp.isHeader(s)){
                		book += "<h1>" + s + "</h1>\n";
                	} // put in header tags
                	
                	if(wasParagraph && !bp.isParagraph(s)){
            			book += "</p>\n" + s;
            		} // if last line was a paragraph but this one isn't close the tag
                	if(bp.isParagraph(s)){
                		if(wasParagraph){
                			book += " " + s;
                		}// continue tag
                		else{
                			book += "<p>" + s;
                		} // start tag since last one wasn't a paragraph
                	}
        		}
        		
        	}
        	wasReturn = s.equals("\n");
        	wasParagraph = bp.isParagraph(s);
        }
        	
        in.close();
        System.out.println(book);
	}

}
