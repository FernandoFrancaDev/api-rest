package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Marca;
import app.entity.Teclado;

public interface TecladoRepository extends JpaRepository<Teclado, Long> {
	
	public List<Teclado> findByNome(String nome);
	
	public List<Teclado> findByMarca(Marca marca);
	
	@Query("FROM Teclado c WHERE c.ano > :ano")
	public List<Teclado> findAcimaAno(int ano);

}
