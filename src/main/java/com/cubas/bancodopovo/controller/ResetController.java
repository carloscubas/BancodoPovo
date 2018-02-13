package com.cubas.bancodopovo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cubas.bancodopovo.repository.ContaRepository;
import com.cubas.bancodopovo.repository.CorrentistaRepository;
import com.cubas.bancodopovo.repository.HistoricoRepository;

@Controller
public class ResetController {
	
	@Autowired
	CorrentistaRepository correntistaRepository;
	
	@Autowired
	ContaRepository contaRepository;
	
	@Autowired
	HistoricoRepository historicoRepository;
	
	@GetMapping("/reset")
	public ModelAndView reset() {
		
		historicoRepository.deleteAll();
		contaRepository.deleteAll();
		correntistaRepository.deleteAll();
		
		return new ModelAndView("redirect:/correntista/lista");
		
	}

}
