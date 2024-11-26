package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Comida;
import app.entity.Marca;

public interface ComidaRepository extends JpaRepository<Comida, Long> {
	
	public List<Comida> findByNome(String nome);
	
	public List<Comida> findByMarca(Marca marca);
	
	@Query("FROM Comida c WHERE c.validade > :validade")
	public List<Comida> findAcimaValidade (int validade);

}
