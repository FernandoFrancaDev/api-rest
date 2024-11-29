package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Casa;
import app.entity.Marca;

public interface CasaRepository extends JpaRepository<Casa, Long> {
	
	public List<Casa> findByNome(String nome);
	
	public List<Casa> findByMarca(Marca marca);	
	
	@Query("FROM Casa c WHERE c.anoFabricacao > :anoFabricacao")
	public List<Casa> findAcimaAnoFabricacao(int anoFabricacao);

}
