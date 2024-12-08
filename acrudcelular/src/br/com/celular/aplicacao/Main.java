package br.com.celular.aplicacao;

import br.com.celular.dao.CelularDao;
import br.com.celular.modal.Celular;

public class Main {
	public static void main(String[] args) {
		
		CelularDao celularDao = new CelularDao();
		
		Celular celular = new Celular();
		celular.setNome("Motorola");
		celular.setAno(2019);
		celular.setPreco(600.00);
		
		celularDao.save(celular);
	}	

}
