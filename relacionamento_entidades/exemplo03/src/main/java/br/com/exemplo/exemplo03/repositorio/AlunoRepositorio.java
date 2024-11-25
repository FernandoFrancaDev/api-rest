package br.com.exemplo.exemplo03.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.exemplo.exemplo03.modelo.Aluno;

@Repository
public interface AlunoRepositorio extends CrudRepository<Aluno, Long>{    

    
}
