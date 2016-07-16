package utils;

import java.util.Random;

import io.codearte.jfairy.Fairy;

public class TestUtils {
	private static final String ALL_DIGITS = "0123456789"; 
	
	public static byte[] getRandomBytes(int size){
		return getRandomString(size/2).getBytes();
	}
	
	public static String getRandomString(int length){
		Fairy fairy = Fairy.create();
		return fairy.textProducer().randomString(length);
	}
	
	public static String getRandomIntegerString(int length){
		Random rand = new Random(ALL_DIGITS.length());
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i<length;i++){
			builder.append(ALL_DIGITS.charAt(rand.nextInt()));
		}
		return builder.toString();
	}
}
