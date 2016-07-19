package photoapplication.database.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import photoapplication.database.entity.Image;
import photoapplication.database.entity.ImageUser;

public interface ImageService {
	Image addImage();
	void delete(long id);
	List<Image> getByUser(ImageUser user);
	void addImage(String name, MultipartFile file);
}
