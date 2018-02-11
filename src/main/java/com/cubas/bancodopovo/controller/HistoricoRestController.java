package com.cubas.bancodopovo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cubas.bancodopovo.model.AjaxResponseBody;
import com.cubas.bancodopovo.model.Conta;
import com.cubas.bancodopovo.model.Historico;
import com.cubas.bancodopovo.repository.ContaRepository;
import com.cubas.bancodopovo.repository.HistoricoRepository;

@RestController
@RequestMapping("/historico")
public class HistoricoRestController {
	
	@Autowired
	ContaRepository contaRepository;
	
	@Autowired
	HistoricoRepository historicoRepository;
	
	@PostMapping("/addhistorico")
	public ResponseEntity<?> create(@RequestBody Historico historico) {
		
		Conta conta = contaRepository.findOne(historico.getIdConta());
		historico.setConta(conta);

		historicoRepository.save(historico);
		
		conta.getHistoricos().add(historico);
		
		contaRepository.save(conta);
		
		AjaxResponseBody response = new AjaxResponseBody(conta.getSaldo(), conta.getHistoricos());
		
		return ResponseEntity.ok(response);
		
	}

}
