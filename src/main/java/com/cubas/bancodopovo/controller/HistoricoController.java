package com.cubas.bancodopovo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cubas.bancodopovo.model.Conta;
import com.cubas.bancodopovo.model.Historico;
import com.cubas.bancodopovo.repository.ContaRepository;
import com.cubas.bancodopovo.repository.HistoricoRepository;

@Controller
@RequestMapping("/historico")
public class HistoricoController {
	
	@Autowired
	ContaRepository contaRepository;
	
	@Autowired
	HistoricoRepository historicoRepository;
	
	@GetMapping("/conta/{id}")
	public ModelAndView historicoCOnta(@PathVariable("id") Long idConta) {
		
		Conta conta = contaRepository.findOne(idConta);
		
		ModelAndView modelAndView = new ModelAndView("historico/conta");
		modelAndView.addObject("historico", new Historico());
		modelAndView.addObject("conta", conta);
		
		return modelAndView;
	}
	
	


}
