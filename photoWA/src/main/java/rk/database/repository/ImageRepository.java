package rk.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rk.database.entity.Image;


public interface ImageRepository extends JpaRepository<Image, Long>{

}
