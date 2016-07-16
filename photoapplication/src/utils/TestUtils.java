package utils;

import io.codearte.jfairy.Fairy;

public class TestUtils {
	public static byte[] getRandomBytes(int size){
		return getRandomString(size/2).getBytes();
	}
	
	public static String getRandomString(int length){
		Fairy fairy = Fairy.create();
		return fairy.textProducer().randomString(length);
	}
}
