package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Computador;
import app.entity.Marca;

public interface ComputadorRepository extends JpaRepository<Computador, Long> {
	
	public List<Computador> findByNome(String nome);
	
	public List<Computador> findByMarca (Marca marca);
	
	@Query("FROM Computador c WHERE c.valor > :valor")
	public List<Computador> findAcimaValor(double valor);

}
