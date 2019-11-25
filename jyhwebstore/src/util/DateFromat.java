package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFromat {
	public static String DateFormat(Date date){
		if(date==null){
			return null;
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		return time;
	}

}
