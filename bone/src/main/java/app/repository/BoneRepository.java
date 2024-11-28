package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Bone;

public interface BoneRepository extends JpaRepository<Bone, Long>{

}
