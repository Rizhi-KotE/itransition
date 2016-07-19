package photoapplication.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import photoapplication.dao.interfaces.ImageDAO;
import photoapplication.dao.objects.User;
import photoapplication.dataexam.entity.Image;

@Component("testImageDAO")
public class TestImageDao implements ImageDAO{

	private static Map<String, Image> images;
	static{
		images = new HashMap<>();
	}
	@Override
	public void insert(Image image) {
		images.put(image.getName(), image);
	}

	@Override
	public void delete(Image image) {
		images.remove(image.getName());
	}

	@Override
	public Image getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Image> getByName(String name) {
		Image image = images.get(name);
		return Arrays.asList(image);
	}

	@Override
	public List<Image> getByAuthor(User author) {
		return new ArrayList<>(images.values());
	}

}
