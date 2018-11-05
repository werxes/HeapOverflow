package HeapOverflow.service;

import javax.annotation.Nonnull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import HeapOverflow.domains.User;
import HeapOverflow.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(@Nonnull String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException(SpringSecurityMessageSource.getAccessor().getMessage(
					"AbstractUserDetailsAuthenticationProvider.UserUnknown", new Object[] { username },
					"User is not known"));
		}

		return user;

	}

}
