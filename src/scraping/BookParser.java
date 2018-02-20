package scraping;

public class BookParser implements HTMLParser{

	@Override
	public boolean isParagraph(String s) {
		// it is a paragraph if it is not a header
		if(!isHeader(s) && !s.equals("")){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean isHeader(String s) {
		if(s.contains("CHAPTER ")){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public String replaceSpecialCharacters(String s){
		s = s.replace("\"", "&ldquo;");
		s = s.replace("\"", "&rdquo;");
		s = s.replace("\'", "&lsquo;");
		s = s.replace("\'", "&rsquo;");
		s = s.replace("-", "&emdash;");
		s = s.replace("<", "&lt;");
		s = s.replace(">", "&gt;");
		s = s.replace("&", "&amp;");
		return s;
	}

}
