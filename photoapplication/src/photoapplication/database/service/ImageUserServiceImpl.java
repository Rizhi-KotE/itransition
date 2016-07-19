package photoapplication.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import photoapplication.database.entity.ImageUser;
import photoapplication.database.repository.ImageUserRepository;

@Service
public class ImageUserServiceImpl implements ImageUserService {
	
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
}
