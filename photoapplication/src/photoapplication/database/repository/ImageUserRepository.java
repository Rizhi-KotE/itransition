package photoapplication.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import photoapplication.database.entity.ImageUser;

public interface ImageUserRepository extends JpaRepository<ImageUser, Long>{

	@Query("select u from #{#entityName} u where u.username = ?1")
	ImageUser findByUsername(String username);
}
