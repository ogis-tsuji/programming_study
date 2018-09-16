import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractAAAReg implements ExtractAAA {
	private int num;
	public ExtractAAAReg(){
		this.num = 2;
	}
	public ExtractAAAReg(int num){
		this.num = num - 1;
	}
	public String convert(String s){
		String regex = "([A-Z])\\1{" + num + "}";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(s);
		String result = m.replaceAll("[$0]");
		return result;
	}
}
