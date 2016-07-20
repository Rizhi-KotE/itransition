package photoapplication.database.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import utils.TestUtils;

@Component
public class TestImageResource implements ImageResource{

	private Map<String, String> imageId = new HashMap();
	@Override
	public String save(InputStream stream) {
		String id = TestUtils.getRandomString(5);
		String url = TestUtils.getRandomString(5);
		imageId.put(id, url);
		return id;
	}

	@Override
	public InputStream load(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUrl(String name) {
		return imageId.get(name);
	}

}
