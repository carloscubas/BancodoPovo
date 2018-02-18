package com.cubas.bancodopovo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cubas.bancodopovo.model.Correntista;

public interface CorrentistaRepository extends JpaRepository<Correntista, Long> { 
	
	Correntista findByNome(String nome);

}
