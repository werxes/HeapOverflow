package HeapOverflow.domains;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("unused")
@Entity
@Table(name = "usr")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Transient
	private Set<Role> authorities;
	private String password;
	private String username;

	@Transient
	private boolean accountNonExpired;
	@Transient
	private boolean accountNonLocked;
	@Transient
	private boolean credentialsNonExpired;
	@Transient
	private boolean enabled;

	public Set<Role> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
	}

	public User() {
	}

	public User(Set<Role> authorities, String password, String username, boolean accountNonExpired,
			boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {

		this.authorities = authorities;
		this.password = password;
		this.username = username;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
