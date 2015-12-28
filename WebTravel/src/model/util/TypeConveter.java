package model.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class TypeConveter{
	public static String parseBase64(byte[] src){
		return Base64.getEncoder().encodeToString(src);
	}
	
	public static JSONObject parseJSONObject(Object bean){
		return (new JSONObject(bean));
	}
	public static JSONArray parseJSONArray(List li){
		return (new JSONArray(li));
	}	
	
	
	public static java.sql.Timestamp parseTimestamp(java.util.Date dateTime){
		return (new java.sql.Timestamp(dateTime.getTime()));
	}
	
	public static java.sql.Timestamp parseTimestamp(String dateTime){
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    java.sql.Timestamp result = null;
	    try{
	        result = parseTimestamp(sdf.parse(dateTime));
	    }catch(ParseException e) {
		    e.printStackTrace();
	    }
	    return result;
	}
	
	public static java.sql.Date parseDate(java.util.Date date){
		return (new java.sql.Date(date.getTime()));
	}
	
	public static java.sql.Date parseDate(String date){
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    java.sql.Date result = null;
	    try{
		    result = parseDate(sdf.parse(date));
	    }catch (ParseException e) {
		    e.printStackTrace();
		}
	    return result;
	}	
	
	public static java.sql.Time parseTime(java.util.Date time){
		return (new java.sql.Time(time.getTime()));
	}	
	
	public static java.sql.Time parseTime(String time){
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	    java.sql.Time result = null;
	    try{
	    	result = parseTime(sdf.parse(time));
	    }catch (ParseException e) {
		    e.printStackTrace();
		}
	    return result;
	}	
	
	public static byte[] parseByteArray(String src){  //parse file to byte array
	    File file = new File(src);
	    FileInputStream fis = null;
	    byte[] result = null;
		try {
			fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];	
		    for (int readNum; (readNum = fis.read(buf)) != -1;) {
		        bos.write(buf, 0, readNum); //no doubt here is 0
		    }
		    result = bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
		return result;		
	}
	
	
}
