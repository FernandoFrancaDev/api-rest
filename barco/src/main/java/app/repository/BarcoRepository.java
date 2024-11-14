package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Barco;

public interface BarcoRepository extends JpaRepository<Barco, Long> {

}
