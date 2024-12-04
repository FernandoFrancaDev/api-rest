package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Cerveja;

public interface CervejaRepository extends JpaRepository<Cerveja, Long> {

}
