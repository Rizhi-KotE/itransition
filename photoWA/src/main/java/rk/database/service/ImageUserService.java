package rk.database.service;

import java.util.List;

import rk.database.entity.ImageUser;
import rk.web.dto.UserDTO;

public interface ImageUserService {
	ImageUser addUser(ImageUser user);

	List<ImageUser> getAll();

	ImageUser getById(long id);

	void delete(long id);

	ImageUser findByUserName(String username);

	ImageUser registerNewUserAccount(UserDTO accountDto) throws EmailExistsException;

	ImageUser findByEmail(String userName);
}
