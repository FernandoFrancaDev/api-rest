package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Aviao;

public interface AviaoRepository extends JpaRepository<Aviao, Long> {

}
