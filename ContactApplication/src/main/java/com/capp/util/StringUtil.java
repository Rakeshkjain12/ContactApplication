package com.capp.util;
/*
 * This Class Contain Utility methods related to String Operations.
 * */
public class StringUtil {
   public static String toCommaSeparatedString(Object[] items){
	  StringBuffer sb=new StringBuffer();
	  for (Object item : items) {
		sb.append(item).append(",");
	}
	  if(sb.length()>0){
		  sb.deleteCharAt(sb.length()-1);
	  }
	return sb.toString();
	}
}
