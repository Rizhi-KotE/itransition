package photoapplication.dataexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import photoapplication.dataexam.entity.ImageUser;

public interface ImageUserRepository extends JpaRepository<ImageUser, Long>{
	
	@Query("select user from users user where user.name = :name")
	ImageUser findByName(@Param("name") String name);
}
