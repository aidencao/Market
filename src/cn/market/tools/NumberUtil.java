package cn.market.tools;

import java.math.BigDecimal;


public class NumberUtil {
	//判断字符串是否是数字
	 public static boolean isNumeric(String str) {
	        for (int i = 0; i < str.length(); i++) {
	            System.out.println(str.charAt(i));
	            if (!Character.isDigit(str.charAt(i))) {
	                return false;
	            }
	        }
	        return true;
	    }
	 
	 //浮点数四舍五入保留两位数
	 public static double formatDouble(double num)
	 {
		 BigDecimal bg = new BigDecimal(num).setScale(2, BigDecimal.ROUND_HALF_UP);
		 return bg.doubleValue();
	 }
}
