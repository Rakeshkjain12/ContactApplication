package com.capp.util;

public class otpValidation {
	private static String em=null;
	private  static String otp=null;
	
	public static void SetOtp(String email,String otp1) {
		
		em=email;
		otp=otp1;
       }
	
	public static boolean isCorrectOTP(String email, String otp1) {
		if(email.equals(em)&&otp1.equals(otp)) {
			return true;
		}else {
			return false;
		}
	}
}
