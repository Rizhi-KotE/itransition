package rk.database.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import rk.database.entity.ImageUser;
import rk.database.repository.ImageUserRepository;
import rk.web.dto.UserDTO;


@Service
public class ImageUserServiceImpl implements ImageUserService{

	private ImageUserRepository imageUserRepository;

	@Override
	public ImageUser addUser(ImageUser user) {
		return imageUserRepository.saveAndFlush(user);
	}

	@Override
	public void delete(long id) {
		imageUserRepository.delete(id);
	}

	@Override
	public List<ImageUser> getAll() {
		return imageUserRepository.findAll();
	}

	@Override
	public ImageUser getById(long id) {
		return imageUserRepository.findOne(id);
	}

	@Autowired
	public void setImageUserRepository(ImageUserRepository imageUserRepository) {
		this.imageUserRepository = imageUserRepository;
	}

	@Override
	public ImageUser findByUserName(String username) {
		return imageUserRepository.findByUsername(username);
	}



	@Transactional
    @Override
    public ImageUser registerNewUserAccount(UserDTO accountDto) throws EmailExistsException {
        if (emailExist(accountDto.getEmail())) {  
            throw new EmailExistsException("There is an account with that email adress: " + 
              accountDto.getEmail());
        }
        ImageUser user = new ImageUser();    
        user.setUsername(accountDto.getUsername());
        user.setPassword(encodeUserPassword(accountDto));
        user.setEmail(accountDto.getEmail());
        user.setRole(1);
        return imageUserRepository.save(user);       
    }

	private String encodeUserPassword(UserDTO accountDto) {
		PasswordEncoder encoder = new StandardPasswordEncoder();
		return encoder.encode(accountDto.getPassword());
	}

	private boolean emailExist(String email) {
		ImageUser user = imageUserRepository.findByEmail(email);
		return user == null ? false : true;
	}

	@Override
	public ImageUser findByEmail(String userName) {
		return imageUserRepository.findByEmail(userName);
	}
}
