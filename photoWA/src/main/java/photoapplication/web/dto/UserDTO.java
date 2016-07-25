package photoapplication.web.dto;

import org.hibernate.validator.constraints.NotEmpty;
import photoapplication.web.validation.ValidEmail;

import javax.validation.constraints.NotNull;

@PasswordMatches
public class UserDTO {
	@NotNull
	@NotEmpty
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull
	@NotEmpty
	private String password;

	@NotNull
	@NotEmpty
	private String matchingPassword;

	@NotNull
	@NotEmpty
	@ValidEmail
	private String email;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
