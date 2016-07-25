package photoapplication.database.service;

import photoapplication.database.entity.ImageUser;
import photoapplication.web.dto.UserDTO;

import java.util.List;

public interface ImageUserService {
	ImageUser addUser(ImageUser user);

	List<ImageUser> getAll();

	ImageUser getById(long id);

	void delete(long id);

	ImageUser findByUserName(String username);

	ImageUser registerNewUserAccount(UserDTO accountDto) throws EmailExistsException;

	ImageUser findByEmail(String userName);
}
