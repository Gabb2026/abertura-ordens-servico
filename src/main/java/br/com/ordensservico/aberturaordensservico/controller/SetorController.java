package br.com.ordensservico.aberturaordensservico.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.ordensservico.aberturaordensservico.model.Setor;
import br.com.ordensservico.aberturaordensservico.service.SetorService;

@RestController 
@RequestMapping ("/setor") 
public class SetorController {
    private final SetorService setorService;
    public SetorController(SetorService setorService) {
        this.setorService = setorService;
    }
    @PostMapping 
    public ResponseEntity<Setor> cadastrar(@RequestBody Setor setor){
        Setor setorCadastrado = setorService.cadastrar(setor);
        return ResponseEntity.status(201).body(setorCadastrado);

    }
    @GetMapping
    public ResponseEntity<List<Setor>> listarSetores(){
        List<Setor> setores = setorService.listarSetores();
        return ResponseEntity.ok(setores);
    }   
    @GetMapping ("/{id}")
    public ResponseEntity<Setor> listarSetoresPorId(@PathVariable Integer id){
        return setorService.ListarSetoresPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    

}
