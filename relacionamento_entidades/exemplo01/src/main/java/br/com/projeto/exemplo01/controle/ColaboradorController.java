package br.com.projeto.exemplo01.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.exemplo01.modelo.Colaborador;
import br.com.projeto.exemplo01.repositorio.ColaboradorRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepositorio colaboradorRepositorio;   

    @GetMapping("/listar")
    public Iterable<Colaborador> listar(){
        return colaboradorRepositorio.findAll();
    }    
       
    @PostMapping("/cadastrar")
    public Colaborador cadastrar(@RequestBody Colaborador obj){
        return colaboradorRepositorio.save(obj);

    }
}
