package photoapplication.dao.interfaces;

import java.util.List;

import photoapplication.dao.objects.Image;
import photoapplication.dao.objects.User;

public interface ImageDAO {
	void insert(Image image);

	void delete(Image image);

	Image getById(int id);

	List<Image> getByName(String name);

	List<Image> getByAuthor(User author);
}
