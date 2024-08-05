package _daysofcode.demo.controller;

import _daysofcode.demo.infra.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("superherois")
public class SuperHeroisController {


    @Autowired
    private SuperHeroisRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrarSuper(@RequestBody DadosSuperHerois dados){
    var superHerois = new SuperHerois(dados);
    repository.save(superHerois);
    return ResponseEntity.ok().body(superHerois);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemSuperHerois>> listar(@PageableDefault(size = 10,sort = {"nome"}) Pageable paginacao){
        var p= repository.findAllByAtivoTrue(paginacao).map(DadosListagemSuperHerois::new);
        return ResponseEntity.ok(p);
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizarSuper(@RequestBody DadosAtualizacaoSuperHerois dados){
        var superHerois= repository.getReferenceById(dados.id());
        superHerois.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhadosSupers(superHerois));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var superHerois = repository.findById(id);
        if (superHerois.isPresent()) {
            repository.delete(superHerois.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}