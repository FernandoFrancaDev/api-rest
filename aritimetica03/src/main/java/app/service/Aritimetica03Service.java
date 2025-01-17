package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Entrada;
import app.entity.Resultado;


@Service
public class Aritimetica03Service {
	
	
	
	public Resultado calcular(Entrada entrada) {
		Resultado resultado = new Resultado();
		
		resultado.setSoma(this.somar(entrada.getLista()));
	//	Double media = (double) soma/entrada.getLista().size();
	//	resultado.setMedia(media);
		resultado.setMaior(this.buscarMaiorNumero(entrada.getLista()));
		resultado.setMenor(this.buscaMenorNumero(entrada.getLista()));
		resultado.setTotal(this.buscaTotalNumero(entrada.getLista()));
		
	
		
		return resultado;
	}
	public int somar(List<Integer> lista) {
		int soma = 0;
		if(lista != null)
			for(int i = 0; i < lista.size(); i++) {
				soma += lista.get(i);				
			}	
		return soma;
	}
	public int  buscarMaiorNumero(List<Integer> lista) {
		int maiorNumero = Integer.MIN_VALUE;		
		for(int i = 0; i < lista.size(); i++)
			if(lista.get(i) > maiorNumero) {
				maiorNumero = lista.get(i);
			}					
		return maiorNumero;		
	}
	public int buscaMenorNumero(List<Integer> lista) {
		int menorNumero = Integer.MAX_VALUE;
		for (int i = 0; i < lista.size(); i++)			
			if( lista.get(i) < menorNumero) {
				menorNumero = lista.get(i);
			}
				
		return menorNumero;		
	}
	public int buscaTotalNumero(List<Integer> lista) {
		int somaTotal = 0;
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i) != null)
				somaTotal ++;
		}		
		return somaTotal;
	}
	

}
