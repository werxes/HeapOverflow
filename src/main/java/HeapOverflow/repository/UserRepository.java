package HeapOverflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import HeapOverflow.domains.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
