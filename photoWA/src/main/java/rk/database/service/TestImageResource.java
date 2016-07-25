package rk.database.service;

import org.springframework.stereotype.Component;
import utils.TestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Component
public class TestImageResource implements ImageResource {

	private Map<String, String> imageId = new HashMap<String, String>();

	@Override
	public InputStream load(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUrl(String name) {
		return imageId.get(name);
	}

	@Override
	public String save(Object file) throws IOException {
		String id = TestUtils.getRandomString(5);
		String url = TestUtils.getRandomString(5);
		imageId.put(id, url);
		return id;
	}

}
