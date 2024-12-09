package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Perfume;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {

}
