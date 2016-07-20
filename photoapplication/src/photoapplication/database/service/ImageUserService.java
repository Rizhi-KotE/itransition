package photoapplication.database.service;

import java.util.List;

import photoapplication.database.entity.ImageUser;

public interface ImageUserService {
	ImageUser addUser(ImageUser user);

	List<ImageUser> getAll();

	ImageUser getById(long id);

	void delete(long id);

	ImageUser findByUserName(String username);
}
