package com.sistemadegerenciamento.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemadegerenciamento.demo.model.Refatoracao;

@Repository
public interface RefatoracaoRepository extends JpaRepository<Refatoracao, Long> {
}