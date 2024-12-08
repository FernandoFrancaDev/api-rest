package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Camera;

public interface CameraRepository extends JpaRepository <Camera, Long>{

}
