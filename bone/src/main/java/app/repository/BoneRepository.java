package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Bone;
import app.entity.Marca;

public interface BoneRepository extends JpaRepository<Bone, Long>{
	
	public List<Bone> findByNome(String nome);
	
	public List<Bone> findByMarca(Marca marca);
	
	@Query("FROM Bone c WHERE c.anoFabricacao > :anoFabricacao")
	public List<Bone> findAcimaAno(int anoFabricacao);
	

}
