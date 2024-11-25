package br.com.exemplo.exemplo03;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.exemplo.exemplo03.modelo.Aluno;
import br.com.exemplo.exemplo03.modelo.Curso;
import br.com.exemplo.exemplo03.repositorio.AlunoRepositorio;
import br.com.exemplo.exemplo03.repositorio.CursoRepositorio;

@SpringBootApplication
public class Exemplo03Application {

	public static void main(String[] args) {
		SpringApplication.run(Exemplo03Application.class, args);
	}
	@Bean
	public CommandLineRunner mappingDemo(AlunoRepositorio ar, CursoRepositorio cr){
		return args ->{
			// criar um aluno
			Aluno aluno = new Aluno();
			aluno.setAluno("Carlos");

			// cadastrar na tabela alunos
			ar.save(aluno);

			// criar três cursos
			Curso c1 = new Curso();
			c1.setCurso("Java - Spring Boot");

			Curso c2 = new Curso();
			c2.setCurso("Mysql - Banco de Dados");

			Curso c3 = new Curso();
			c3.setCurso("Github - Versionamento de Códigos");

			// Cadastrar os cursos na tabela cursos
			cr.saveAll((Arrays.asList(c1, c2, c3)));

			// Adicionar o primeiro e o terceiro curso no aluno
			aluno.getCursos().addAll(Arrays.asList(c1, c3));

			// atualizar a lista de cursos do aluno
			ar.save(aluno);

		};
	}

}
