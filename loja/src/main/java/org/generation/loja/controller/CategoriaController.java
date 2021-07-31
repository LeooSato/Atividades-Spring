package org.generation.loja.controller;

import java.util.*;
import org.generation.loja.model.Categoria;
import org.generation.loja.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

    @Autowired
    private CategoriaRepository CategoriaRep;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok(CategoriaRep.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Categoria> getById(@PathVariable long id){

        return CategoriaRep.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Categoria>> GetByTipo(@PathVariable String descricao){

        return ResponseEntity.ok(CategoriaRep.findAllBydescricaoContainingIgnoreCase(descricao));
    }

    @PostMapping
    public ResponseEntity<Categoria> post(@RequestBody Categoria categoria){

        return ResponseEntity.status(HttpStatus.CREATED).body(CategoriaRep.save(categoria));
    }

    @PutMapping
    public ResponseEntity<Categoria> put(@RequestBody Categoria categoria){

        return ResponseEntity.status(HttpStatus.OK).body(CategoriaRep.save(categoria));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        CategoriaRep.deleteById(id);
    }
}
