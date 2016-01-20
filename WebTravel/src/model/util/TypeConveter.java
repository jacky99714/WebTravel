package model.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

import model.bean.SceneBean;
import model.bean.ThoughtBean;
import other.bean.FavoriteBean;
import other.bean.MythoughtBean;


public class TypeConveter{
	public static String EncodeBase64(byte[] src){
		if(src == null){
			return null;
		}
		return Base64.encodeBase64String(src);
	}
		
	public static String EncodeStringBase64(String src){  //source image path
		if(src == null){
			return null;
		}
		 return EncodeBase64(src.getBytes());
	}	
	
	public static byte[] DecodeBase64(String src){
		if(src == null){
			return null;
		}
		return Base64.decodeBase64(src);
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
	

	
	public static byte[] parseByteArray(String fileSrc){  //parse file to byte array
	    File file = new File(fileSrc);
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
	
	public static FavoriteBean parseFavoriteBean(SceneBean bean){  
		FavoriteBean fb = null;
		if(bean != null){
			fb = new FavoriteBean();
			fb.setSceneId(bean.getSceneId());
			fb.setLocation(bean.getLocation());
			fb.setCity(bean.getCity());
			fb.setSceneName(bean.getSceneName());
			fb.setScenePhoto(TypeConveter.EncodeBase64(bean.getScenePhoto()));
			fb.setSceneContent(bean.getSceneContent());
			fb.setTimeStart(bean.getTimeStart());
			fb.setTimeEnd(bean.getTimeEnd());
			fb.setMemberId(bean.getMemberId());			
		}
		return fb;
	}
	public static MythoughtBean pareseMythoughtBean(ThoughtBean bean){
		MythoughtBean mb = null;
		if(bean != null){
			mb = new MythoughtBean();
			mb.setThoughtId(bean.getThoughtId());
			mb.setThoughtName(bean.getThoughtName());
			mb.setThoughtSubtitle(bean.getThoughtSubtitle());
			mb.setThoughtPhoto(Base64.encodeBase64String(bean.getThoughtPhoto()));
			mb.setThoughtTime(bean.getThoughtTime());
			mb.setThoughtContent(bean.getThoughtContent());
			mb.setMemberId(bean.getMemberId());
		}
		return mb;
	}
}
