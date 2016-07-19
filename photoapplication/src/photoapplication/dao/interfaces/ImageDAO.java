package photoapplication.dao.interfaces;

import java.util.List;

import photoapplication.dao.objects.User;
import photoapplication.dataexam.entity.Image;

public interface ImageDAO {
	void insert(Image image);

	void delete(Image image);

	Image getById(int id);

	List<Image> getByName(String name);

	List<Image> getByAuthor(User author);
}
