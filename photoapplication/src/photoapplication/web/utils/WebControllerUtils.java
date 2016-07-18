package photoapplication.web.utils;

import org.apache.tomcat.util.codec.binary.Base64;

public class WebControllerUtils {
	public static String byteToStringBase64(byte[] content){
		Base64 encoder = new Base64();
		return encoder.encodeAsString(content);
	}
}
