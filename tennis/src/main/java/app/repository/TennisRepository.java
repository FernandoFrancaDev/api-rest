package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Tennis;

public interface TennisRepository extends JpaRepository<Tennis, Long> {

}
