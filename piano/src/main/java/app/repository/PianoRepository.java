package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Marca;
import app.entity.Piano;

public interface PianoRepository extends JpaRepository<Piano, Long> {
	
	public List<Piano> findByNome(String nome);
	
	public List<Piano> findByMarca(Marca marca);
	
	@Query("SELECT c FROM Piano c WHERE c.anoFabricacao > :anoFabricacao")
	public List<Piano> findAcimaAno(String anoFabricacao);

	

}
