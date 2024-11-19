package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Dog;
import app.repository.DogRepository;

@Service
public class DogService {
	
	@Autowired
	private DogRepository dogRepository;
	
	public String save(Dog dog) {
		this.dogRepository.save(dog);
		return "Dog salvo com sucessesso!";
	}
	public String update (Dog dog, long id) {
		dog.setId(id);
		this.dogRepository.save(dog);
		return "Dog atualizado com sucessesso!";
	}
	public String delete(long id) {
		this.dogRepository.deleteById(id);
		return "Dog deletado com sucessesso!";
	}
	public List<Dog> findAll(){
		List<Dog> lista = this.dogRepository.findAll();
		return lista;
	}
	public Dog findById(long id) {
		Dog dog = this.dogRepository.findById(id).get();
		return dog;
	}

}
