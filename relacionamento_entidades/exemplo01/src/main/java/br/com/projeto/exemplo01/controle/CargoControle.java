package br.com.projeto.exemplo01.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.exemplo01.modelo.Cargo;
import br.com.projeto.exemplo01.repositorio.CargoRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/cargos")
public class CargoControle {

    @Autowired
    private CargoRepositorio cargoRepositorio;

    @GetMapping("/listar")    
    public Iterable<Cargo> listar(){
        return cargoRepositorio.findAll();
    }
    @PostMapping("/cadastrar")
    public Cargo cadastrar(@RequestBody Cargo obj){
        return cargoRepositorio.save(obj);

    }
    
}
