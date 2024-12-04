package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		ContatoDAO contatoDao = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome("João Silva B");
		contato.setIdade(80);
		contato.setDataCadastro(new Date());
		
		// contatoDao.save(contato);
		
		// Atualizar o contato
		
		Contato c1 = new Contato();
		c1.setNome("Maria gariela Dias Orlando");
		c1.setIdade(37);
		c1.setDataCadastro(new Date());
		c1.setId(1);
		
		//contatoDao.update(c1);
		
		//deletar o contato pelo IF
		
		//contatoDao.deleteById(3);
		
		// visualização de todos os registros de dados
		
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("Contatos: " + c.getNome());
		}
		

	}

}
