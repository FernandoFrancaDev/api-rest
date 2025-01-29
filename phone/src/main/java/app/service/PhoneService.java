package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Phone;
import app.entity.Saida;
import app.repository.PhoneRepository;
@Service
public class PhoneService {
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	public String save(Phone phone) {
		this.phoneRepository.save(phone);
		return "Phone salvo com sucesso";
	}
	public String update(Phone phone, long id) {
		phone.setId(id);
		this.phoneRepository.save(phone);
		return "Phone atualizado com sucesso";
	}		
	public String delete (long id) {
		this.phoneRepository.deleteById(id);
		return "Phone deletado com sucesso";
	}
	public List<Phone> findAll(){
		List<Phone> lista = this.phoneRepository.findAll();
		return lista;
	}
	public Phone findById(long id) {
		Phone phone = this.phoneRepository.findById(id).get();
		return phone;
	}
	public Saida calcular(Phone phone) {
		Saida saida = new Saida();
		saida.setSoma(this.somar(phone.getLista()));
		return null;
	}
	public int somar(List<Integer> lista) {
		int soma = 0;
		for(int i = 0; i < lista.size(); i++)
			if(lista.get(i) != null)
			soma += lista.get(i);
		return soma;		
	}
	
	

}
