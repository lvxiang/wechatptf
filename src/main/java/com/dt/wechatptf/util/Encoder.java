package com.dt.wechatptf.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoder {

	private static MessageDigest SHA1_ENCODER;
	
	static{
		try {
			SHA1_ENCODER = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    /***
     * Use SHA-1 to encode a string, The string must not be null, otherwise
     * {@link NullPointerException} would be thrown. Returned value would be a
     * @param strToEncode
     * @return
     */
    public static String encodeSHA1(String strToEncode){
        if(strToEncode == null)
            throw new NullPointerException("String to be encoded must not be null.");
        SHA1_ENCODER.update(strToEncode.getBytes());
        return bytesToHex(SHA1_ENCODER.digest());
    }

    /**
     * transform a byte array into its corresponding hex-form string.
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes){
        if(bytes == null)
            throw new NullPointerException();
        String result = "";
        for(byte b: bytes){
            String tmp = Integer.toHexString(b & 0xFF);
            if(tmp.length() == 1)
                result += "0";
            result += tmp;
        }
        return result;
    }
}
