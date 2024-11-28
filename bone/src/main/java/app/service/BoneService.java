package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Bone;
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
	
}
	
	
