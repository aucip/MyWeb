package www.web1.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class BaseUtils {
	static public String Encoder(String text){
		byte[] byteOfText = null;
		Base64.Decoder d = Base64.getDecoder();
		Base64.Encoder e = Base64.getEncoder();
		String result = null;
		try {
			byteOfText = text.getBytes("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		result = e.encodeToString(byteOfText);
		return result;
	}
	
	static public String Decoder(String text){
		byte[] byteOfText;
		Base64.Decoder d = Base64.getDecoder();
		Base64.Encoder e = Base64.getEncoder();
		String result = null;
		try {
			result = new String(d.decode(text), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
		String a = BaseUtils.Encoder("sdfsd");
		System.out.println(a);
		System.out.println(BaseUtils.Decoder(a));
		
	}
}
