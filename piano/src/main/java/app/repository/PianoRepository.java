package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Piano;

public interface PianoRepository extends JpaRepository<Piano, Long> {

}
