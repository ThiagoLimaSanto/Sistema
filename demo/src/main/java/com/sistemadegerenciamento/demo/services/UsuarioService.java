package com.sistemadegerenciamento.demo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistemadegerenciamento.demo.model.Usuario;
import com.sistemadegerenciamento.demo.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public void insert(Usuario entity) {
        repository.save(entity);
    }

    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}