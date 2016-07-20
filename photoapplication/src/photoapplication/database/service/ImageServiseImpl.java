package photoapplication.database.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import photoapplication.database.entity.Image;
import photoapplication.database.entity.ImageUser;
import photoapplication.database.repository.ImageRepository;

@Component
public class ImageServiseImpl implements ImageService{

	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private ImageResource imageResource;
	
	@Override
	public Image addImage(Image image, InputStream file) {
		String public_id = saveImageContent(file);
		image.setPublic_Id(public_id);
		return imageRepository.saveAndFlush(image);
	}

	private String saveImageContent(InputStream stream){
		return imageResource.save(stream);
	}

	@Override
	public void delete(long id) {
		imageRepository.delete(id);
	}

	@Override
	public List<Image> getByUser(ImageUser user) {
		return null;
	}

	public void setImageRepository(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}

	public void setImageResource(ImageResource imageResource) {
		this.imageResource = imageResource;
	}

	@Override
	public List<Image> getAll() {
		return imageRepository.findAll();
	}

}
