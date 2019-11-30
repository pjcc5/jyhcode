package util;

public class StringOrArray {
	
	
	public static String[] getArray(String str){
		if(str==null||str.length()<=0){
			return null;
		}
	String[] arr=str.split(",");
	return arr;
	}
	
	public static String getStr(String[] arr){
		if(arr==null||arr.length<=0){
			return null;
		}
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<arr.length;i++){
			
			if(i==arr.length-1){
				sb.append(arr[i]);
			}else{
			sb.append(arr[i]);
			sb.append(",");
			}
		}
		String str=sb.toString();
		return str;
	}

}
