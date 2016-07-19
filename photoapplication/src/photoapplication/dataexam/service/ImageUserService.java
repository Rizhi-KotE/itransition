package photoapplication.dataexam.service;

import java.util.List;

import photoapplication.dataexam.entity.ImageUser;

public interface ImageUserService {
	ImageUser addUser(ImageUser user);
	List<ImageUser> getAll();
	ImageUser getByName(String name);
	ImageUser getById(long id);
	void delete(long id);
}
