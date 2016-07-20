package photoapplication.database.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import photoapplication.database.entity.Image;
import photoapplication.database.entity.ImageUser;

public interface ImageService {
	void delete(long id);

	List<Image> getByUser(ImageUser user);
	
	List<Image> getAll();

	Image addImage(Image image, File file) throws IOException;
	
	Image addImage(Image image, byte[] file) throws IOException;
	
	Image addImage(Image image, String file) throws IOException;
}
