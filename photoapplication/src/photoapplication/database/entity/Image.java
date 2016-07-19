package photoapplication.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image {
	@Id
	private long id;
	
	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private ImageUser user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ImageUser getUser() {
		return user;
	}

	public void setUser(ImageUser user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
