package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFromat {
	public static String DateFormatToString(Date date){
		if(date==null){
			return null;
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		return time;
	}
	public static Date StringFormattoDate(String date) throws ParseException{
		if(date==null){
			return null;
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=format.parse(date);
		return d;
	}

}
