package com.capp.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomOTPUtil {
     public static String randomOTP() {
		return RandomStringUtils.randomAlphanumeric(6);
		}
}
