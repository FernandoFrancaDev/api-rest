package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Marca;
import app.entity.Motos;

public interface MotosRepository extends JpaRepository<Motos, Long> {
	
	public List<Motos>findByNome(String nome);
	
	public List<Motos> findByMarca(Marca marca);
	
	@Query("FROM Motos c WHERE c.ano > :ano")
	public List<Motos> FindAcimaAno(int ano);

}
