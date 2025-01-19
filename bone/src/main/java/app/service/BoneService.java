package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Bone;
import app.entity.Entrada;
import app.entity.Marca;
import app.entity.Saida;
import app.repository.BoneRepository;

@Service
public class BoneService {
	
	@Autowired
	private BoneRepository boneRepository;
	
	public String save(Bone bone) {
		this.boneRepository.save(bone);		
	return "Boné Salvo com sucesso!";
	}
	public String update(Bone bone, long id) {
		bone.setId(id);
		this.boneRepository.save(bone);
		return "Boné Atualizado com sucesso!";
	}
	public String delete(long id) {
		this.boneRepository.deleteById(id);
		return "Boné deletado com sucesso!";
	}
	public List<Bone>findAll(){
		List<Bone> lista = this.boneRepository.findAll();	
	return lista;
	}
	public Bone findById(long id) {
		Bone bone = this.boneRepository.findById(id).get();	
	return bone;	
	}
	public List<Bone> findByNome(String nome){
		return this.boneRepository.findByNome(nome);
	}
	public List<Bone> findByMarca(long id){
		Marca marca = new Marca();
		marca.setId(id);
		return this.boneRepository.findByMarca(marca);
	}
	public List<Bone> findAcimaAno(int anoFabricacao){
	return this.boneRepository.findAcimaAno(anoFabricacao);
	
	}
	public Saida calcular(Entrada entrada) {
		Saida saida = new Saida();
		saida.setSoma(this.somar(entrada.getLista()));
		
		return saida;
	}
	public int somar(List<Integer> lista) {
		int soma = 0;
		for(int i = 0; i < lista.size(); i++)
			soma += lista.get(i);
		return soma;
	}
	
}
	
	
