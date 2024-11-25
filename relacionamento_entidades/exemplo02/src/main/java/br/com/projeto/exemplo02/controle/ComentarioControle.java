package br.com.projeto.exemplo02.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.exemplo02.modelo.Comentario;
import br.com.projeto.exemplo02.repositorio.ComentarioRepositorio;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioControle {

    @Autowired
    private ComentarioRepositorio comentarioRepositorio;

    @GetMapping("/listar")
    public Iterable<Comentario> listar(){
        return comentarioRepositorio.findAll();
    }

    @PostMapping("/cadastrar")
    public Comentario cadastrar(@RequestBody Comentario obj){
        return comentarioRepositorio.save(obj);

    }
}
