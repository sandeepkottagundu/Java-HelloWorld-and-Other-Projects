package scraping;

public interface HTMLParser {
	boolean isParagraph(String s);
	boolean isHeader(String s);
	String replaceSpecialCharacters(String s);
}
