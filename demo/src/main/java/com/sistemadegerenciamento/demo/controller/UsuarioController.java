package com.sistemadegerenciamento.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadegerenciamento.demo.model.Usuario;
import com.sistemadegerenciamento.demo.services.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController implements GenericController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Usuario entity) {
        service.insert(entity);
        return ResponseEntity.created(gerarHeaderLocation(entity.getId())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        return service.findById(id).map(usuario -> {
            return ResponseEntity.ok(usuario);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}