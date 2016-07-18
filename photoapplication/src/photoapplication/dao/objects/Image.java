package photoapplication.dao.objects;

import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class Image {
	
	MultipartFile content;
	
	private String name;

	private User user;

	public byte[] getContent() {
		return null;
	}

	public String getName() {
		return name;
	}

	public User getUser() {
		return user;
	}

	public void setContent(MultipartFile content) {
		this.content = content;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
