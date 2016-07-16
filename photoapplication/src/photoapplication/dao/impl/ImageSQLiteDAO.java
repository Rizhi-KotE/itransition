package photoapplication.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import photoapplication.dao.interfaces.ImageDAO;
import photoapplication.dao.objects.Image;
import photoapplication.dao.objects.User;

@Component("sqLiteImageDao")
public class ImageSQLiteDAO implements ImageDAO{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void insert(Image image) {
		String sql = "insert into images (name, author) VALUES (?,?)";
		jdbcTemplate.update(sql, new Object[]{image.getName(), image.getUser()});
	}

	@Override
	public void delete(Image image) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Image> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Image> getByAuthor(User author) {
		// TODO Auto-generated method stub
		return null;
	}

}
