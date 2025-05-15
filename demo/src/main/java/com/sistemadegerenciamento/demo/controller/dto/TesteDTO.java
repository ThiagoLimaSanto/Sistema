package com.sistemadegerenciamento.demo.controller.dto;

import com.sistemadegerenciamento.demo.model.Teste;
import com.sistemadegerenciamento.demo.model.enuns.ResultadoTeste;

import lombok.Data;

@Data
public class TesteDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Long usuario;
    private ResultadoTeste status;
    private String observacoesGerais;
    private String impacto;

    public Teste toEntity(TesteDTO dto) {
        Teste teste = new Teste();
        teste.setId(dto.id);
        teste.setNome(dto.nome);
        teste.setDescricao(dto.descricao);
        teste.setStatus(dto.status);
        teste.setObservacoesGerais(dto.getObservacoesGerais());
        teste.setImpacto(dto.impacto);
        return teste;
    }
}