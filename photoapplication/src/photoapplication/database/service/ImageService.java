package photoapplication.database.service;

import java.io.InputStream;
import java.util.List;

import photoapplication.database.entity.Image;
import photoapplication.database.entity.ImageUser;

public interface ImageService {
	void delete(long id);

	List<Image> getByUser(ImageUser user);
	
	List<Image> getAll();

	Image addImage(Image image, InputStream fileInputStream);
}
