package photoapplication.database.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import photoapplication.database.entity.ImageUser;
import photoapplication.database.repository.ImageUserRepository;

@Service
public class ImageUserServiceImpl implements ImageUserService, UserDetailsService {

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ImageUser user = imageUserRepository.findByUsername(username);
		if (user != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
			return new User(user.getUsername(), user.getPassword(), authorities);
		}
		throw new UsernameNotFoundException("User '" + username + "' not found.");
	}

}
