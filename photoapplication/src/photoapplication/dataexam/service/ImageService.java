package photoapplication.dataexam.service;

import java.util.List;

import photoapplication.dataexam.entity.Image;
import photoapplication.dataexam.entity.ImageUser;

public interface ImageService {
	Image addImage();
	void delete(long id);
	List<Image> getByUser(ImageUser user);
}
