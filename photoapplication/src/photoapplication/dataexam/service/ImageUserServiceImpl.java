package photoapplication.dataexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import photoapplication.dataexam.entity.ImageUser;
import photoapplication.dataexam.repository.ImageUserRepository;

@Service
public class ImageUserServiceImpl implements ImageUserService {

	@Autowired
	private ImageUserRepository imageUserRepository;

	@Override
	public ImageUser addUser(ImageUser user) {
		return imageUserRepository.saveAndFlush(user);
	}

	@Override
	public List<ImageUser> getAll() {
		return imageUserRepository.findAll();
	}

	@Override
	public ImageUser getByName(String name) {
		return imageUserRepository.findByName(name);
	}

	@Override
	public ImageUser getById(long id) {
		return imageUserRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		imageUserRepository.delete(id);
	}
}
