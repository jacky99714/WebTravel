package model.util;

import java.util.Base64;


public class TypeConveter{
	public static String base64Convert(byte[] src){
		return Base64.getEncoder().encodeToString(src);
	}
	

	
}
