package com.sistemadegerenciamento.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String roles;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Refatoracao> refatoracoes = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "responsavel")
    private List<Relatorios> relatorios = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Teste> testes = new ArrayList<>();
}