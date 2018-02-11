package com.cubas.bancodopovo.controller;

import javax.servlet.RequestDispatcher;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cubas.bancodopovo.model.Conta;
import com.cubas.bancodopovo.model.Correntista;
import com.cubas.bancodopovo.model.Historico;
import com.cubas.bancodopovo.repository.ContaRepository;

@Controller
@RequestMapping("/historico")
public class HistoricoController {
	
	@Autowired
	ContaRepository contaRepository;
	
	@GetMapping("/conta/{id}")
	public ModelAndView historicoCOnta(@PathVariable("id") Long idConta) {
		
		Conta conta = contaRepository.findOne(idConta);
		
		ModelAndView modelAndView = new ModelAndView("historico/conta");
		modelAndView.addObject("historico", new Historico());
		modelAndView.addObject("conta", conta);
		
		return modelAndView;
	}
	


}
