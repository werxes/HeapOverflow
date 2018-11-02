package HeapOverflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import HeapOverflow.domains.Website;

public interface WebsiteRepository extends JpaRepository<Website, Long> {

}
