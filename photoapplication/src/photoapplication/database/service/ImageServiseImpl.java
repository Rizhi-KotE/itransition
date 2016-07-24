package photoapplication.database.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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
	public Image addImage(Image image, File file) throws IOException {
		return addImage(image, (Object)file);
	}
	
	@Override
	public Image addImage(Image image, String file) throws IOException {
		return addImage(image, (Object)file);
	}
	
	@Override
	public Image addImage(Image image, byte[] file) throws IOException {
		return addImage(image, (Object)file);
	}
	
	private Image addImage(Image image, Object file) throws IOException{
		String public_id = saveImageContent(file);
		image.setPublic_Id(public_id);
		return imageRepository.saveAndFlush(image);
	}

	private String saveImageContent(Object stream) throws IOException{
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

	@Override
	public String getImageUrl(Image image) {
		return imageResource.getUrl(image.getPublic_Id());
	}

}
