package photoapplication.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photoapplication.database.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

}
