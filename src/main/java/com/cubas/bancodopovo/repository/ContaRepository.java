package com.cubas.bancodopovo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cubas.bancodopovo.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> { }
