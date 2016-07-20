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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class ImageUser {

	@NotNull
	@Size(min = 5, max = 16)
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Size(min = 2, max = 30)
	@Column(name = "firstName")
	private String firstName;

	@NotNull
	@Size(min = 2, max = 30)
	@Column(name = "lastName")
	private String lastName;
	
	@NotNull
	@Size(min = 5, max = 25)
	@Column(name = "password")
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "id")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	@JoinColumn(name = "image_id")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Image> images;


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
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public List<Image> getImages() {
		return images;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
}
