package photoapplication.database.service;

 import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;

@Component
public class CloudinaryImageLoader implements ImageResource{

	Cloudinary cloudinary = new Cloudinary();

	@Override
	public InputStream load(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCloudName(String name){
		cloudinary.config.cloudName = name;
	}

	public void setApiKey(String key){
		cloudinary.config.apiKey = key;
	}

	public void setApiSecret(String secret){
		cloudinary.config.apiSecret = secret;
	}

	@Override
	public String save(InputStream stream) {
		Map uploadResult = upload(stream);
		return getPublicKey(uploadResult);
	}

	private String getPublicKey(Map uploadResult) {
		return (String)uploadResult.get("public_key");
	}

	private Map upload(InputStream stream) {
		Map params = Collections.EMPTY_MAP;
		Uploader uploader = cloudinary.uploader();
		try {
			return uploader.upload(stream, params);
		} catch (IOException e) {
			return Collections.EMPTY_MAP;
		}
	}

	
	@Override
	public String getUrl(String public_id) {
		return cloudinary.url().generate("name");
	}
	
	
}
