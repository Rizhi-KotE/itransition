package photoapplication.dao.objects;

import java.io.InputStream;

import org.apache.tomcat.util.net.URL;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import com.cloudinary.Cloudinary;

import photoapplication.dao.interfaces.ImageResource;

@Component
public class CloudinaryImageLoader implements ImageResource{

	Cloudinary cloudinary = new Cloudinary();
	
	@Override
	public void save(String name, InputStream stream) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InputStream load(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getUrl(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Required
	public void setCloudName(String name){
		cloudinary.config.cloudName = name;
	}
	
	@Required
	public void setApiKey(String key){
		cloudinary.config.apiKey = key;
	}

	@Required
	public void setApiSecret(String secret){
		cloudinary.config.apiSecret = secret;
	}
}
