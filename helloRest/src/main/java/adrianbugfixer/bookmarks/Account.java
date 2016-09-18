package adrianbugfixer.bookmarks;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account {
	@OneToMany(mappedBy = "account")
	private Set<Bookmark> bookmarks = new HashSet<>();
	
	@Id
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public Account(String username, String password) {
		super();
		this.password = password;
		this.username = username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	public String password;
	public String username;
	
	Account(){};
}
