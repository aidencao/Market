package cn.market.tools;

import java.util.Random;

public class RamdomUtil {
	public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";  

    public static String generateString(int length) {  
        StringBuffer randomChar = new StringBuffer();  
        Random random = new Random();  
        for (int i = 0; i < length; i++) {  
            randomChar.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));  
        }  
        return randomChar.toString();  
    }  
}
