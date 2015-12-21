package model.service;

import java.util.Base64;


public final class ImageToBase64Service{
	public static String convert(byte[] src){
		return Base64.getEncoder().encodeToString(src);
	}
	
}
