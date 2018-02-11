package com.cubas.bancodopovo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cubas.bancodopovo.model.Conta;
import com.cubas.bancodopovo.model.Correntista;
import com.cubas.bancodopovo.repository.ContaRepository;
import com.cubas.bancodopovo.repository.CorrentistaRepository;

@Controller
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	CorrentistaRepository correntistaRepository;
	
	@Autowired
	ContaRepository contaRepository;
	
	@GetMapping("/novo")
	public ModelAndView addConta() {
		
		Iterable<Correntista> correntistas = correntistaRepository.findAll();
		
		ModelAndView modelAndView = new ModelAndView("conta/add");
		modelAndView.addObject("correntistas", correntistas);
		modelAndView.addObject("conta", new Conta());
		return modelAndView;
	}
	
	@PostMapping(params = "form")
	public ModelAndView create(@ModelAttribute("conta") Conta conta) {
		
		contaRepository.save(conta);
		return new ModelAndView("redirect:/conta/lista");
	}
	
	@GetMapping("/lista")
	public ModelAndView lista() {
		Iterable<Conta> contas = contaRepository.findAll();
		return new ModelAndView("conta/lista", "contas", contas);
	}

}
