package mao.soft.web.encryption;

import java.security.MessageDigest;

public class Encryption {
	public String getKey(String password) throws Exception
	{
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(password.getBytes());
		//生成结果
		byte[] result  = md.digest();
		StringBuilder sb = new StringBuilder();
		for (byte b : result) {
			sb.append(Integer.toHexString(b));
		}
		return sb.toString();
	}
}
