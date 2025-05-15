package com.sistemadegerenciamento.demo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistemadegerenciamento.demo.controller.dto.RelatorioDTO;
import com.sistemadegerenciamento.demo.model.Relatorios;
import com.sistemadegerenciamento.demo.repositories.RelatoriosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RelatoriosService {

    private final RelatoriosRepository repository;
    private final UsuarioService usuarioService;
    private final RefatoracaoService refatoracaoService;
    private final TesteService testeService;

    public void insert(RelatorioDTO entity) {
        Relatorios relatorios = new Relatorios();
        relatorios.setResponsavel(usuarioService.findById(entity.getResponsavel()).get());
        relatorios.setRefatoracao(refatoracaoService.findById(entity.getFatoracao()).get());
        relatorios.setTeste(testeService.findById(entity.getTeste()).get());
        repository.save(relatorios);
    }

    public Optional<Relatorios> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}