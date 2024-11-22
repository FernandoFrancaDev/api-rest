package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Marca;
import app.entity.Vinho;

public interface VinhoRepository extends JpaRepository<Vinho, Long> {
	
	public List<Vinho> findByNome(String nome);
	
	public List<Vinho> findByMarca(Marca marca);
	
//	public List<Vinho> findAcimaSafra(String safra);

}
