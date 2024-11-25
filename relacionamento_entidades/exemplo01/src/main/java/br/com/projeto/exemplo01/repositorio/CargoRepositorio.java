package br.com.projeto.exemplo01.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto.exemplo01.modelo.Cargo;

public interface CargoRepositorio extends CrudRepository<Cargo, Long> {
    
}
