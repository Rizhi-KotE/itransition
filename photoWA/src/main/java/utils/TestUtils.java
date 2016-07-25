package utils;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

import java.util.Random;

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
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i<length;i++){
			builder.append(ALL_DIGITS.charAt(rand.nextInt(ALL_DIGITS.length())));
		}
		return builder.toString();
	}
	
	public static Person getRandomPerson(){
		Fairy fairy = Fairy.create();
		return fairy.person();
	}
	
	private static Random rand = new Random();
	public static int getRandomInteger(int rang){
		return rand.nextInt(rang);
	}

	public static long getRandomLong() {
		return rand.nextLong();
	}
}
