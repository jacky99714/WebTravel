package model.util;

import java.util.Base64;

import org.json.JSONObject;


public class TypeConveter{
	public static String base64Convert(byte[] src){
		return Base64.getEncoder().encodeToString(src);
	}
	
	public static JSONObject beanConvert(Object bean){
		return (new JSONObject(bean));
	}
	

	

	
}
