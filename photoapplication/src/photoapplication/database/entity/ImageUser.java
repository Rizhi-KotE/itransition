package photoapplication.database.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
public class ImageUser {

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "id")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	@JoinColumn(name = "image_id")
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Image> images;

	@Column(name = "username")
	private String name;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImageUser other = (ImageUser) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public long getId() {
		return id;
	}

	public List<Image> getImages() {
		return images;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public void setName(String name) {
		this.name = name;
	}

}
