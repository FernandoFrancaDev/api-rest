package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Mochila;

public interface MochilaRepository extends JpaRepository<Mochila, Long> {

}
