package rk.database.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Image {
	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "id")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "public_id")
	private String public_Id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private ImageUser user;
	

	public ImageUser getUser() {
		return user;
	}

	public void setUser(ImageUser user) {
		this.user = user;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Image other = (Image) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (public_Id == null) {
			if (other.public_Id != null)
				return false;
		} else if (!public_Id.equals(other.public_Id))
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPublic_Id() {
		return public_Id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((public_Id == null) ? 0 : public_Id.hashCode());
		return result;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPublic_Id(String public_Id) {
		this.public_Id = public_Id;
	}
}
