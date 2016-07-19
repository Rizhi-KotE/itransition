package photoapplication.dataexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import photoapplication.dataexam.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

}
