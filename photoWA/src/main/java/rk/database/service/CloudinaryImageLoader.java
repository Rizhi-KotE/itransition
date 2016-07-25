package rk.database.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

@Component
public class CloudinaryImageLoader implements ImageResource {

	Cloudinary cloudinary = new Cloudinary();

	@Override
	public InputStream load(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCloudName(String name) {
		cloudinary.config.cloudName = name;
	}

	public void setApiKey(String key) {
		cloudinary.config.apiKey = key;
	}

	public void setApiSecret(String secret) {
		cloudinary.config.apiSecret = secret;
	}

	
	@Override
	public String save(Object stream) throws IOException {
		Map<String, Object> uploadResult = upload(stream);
		return getPublicKey(uploadResult);
	}

	private String getPublicKey(Map<String, Object> uploadResult) {
		return (String) uploadResult.get("public_key");
	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> upload(Object file) throws IOException {
		Map<String, Object> params = Collections.emptyMap();
		Uploader uploader = cloudinary.uploader();
		return (Map<String, Object>)uploader.upload(file, params);

	}

	@Override
	public String getUrl(String public_id) {
		return cloudinary.url().generate("name");
	}

}
