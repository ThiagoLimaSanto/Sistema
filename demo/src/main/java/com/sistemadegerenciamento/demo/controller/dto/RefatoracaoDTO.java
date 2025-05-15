package com.sistemadegerenciamento.demo.controller.dto;

import com.sistemadegerenciamento.demo.model.Refatoracao;
import com.sistemadegerenciamento.demo.model.enuns.ResultadoRefatoracao;

import lombok.Data;

@Data
public class RefatoracaoDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private Long usuario;
    private ResultadoRefatoracao status;

    public Refatoracao toEntity(RefatoracaoDTO dto) {
        Refatoracao Refatoracao = new Refatoracao();
        Refatoracao.setId(dto.id);
        Refatoracao.setTitulo(dto.titulo);
        Refatoracao.setDescricao(dto.descricao);
        Refatoracao.setStatus(dto.status);
        return Refatoracao;
    }
}