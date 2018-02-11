package com.cubas.bancodopovo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cubas.bancodopovo.model.Correntista;
import com.cubas.bancodopovo.repository.CorrentistaRepository;

@Controller
@RequestMapping("/correntista")
public class CorrentistaController {

	@Autowired
	CorrentistaRepository correntistaRepository;

	@GetMapping("/novo")
	public ModelAndView addCorrentista() {
		return new ModelAndView("correntista/add", "correntista", new Correntista());
	}

	@PostMapping(params = "form")
	public ModelAndView create(@ModelAttribute("correntista") Correntista correntista) {
		correntistaRepository.save(correntista);
		return new ModelAndView("redirect:/correntista/lista");
	}
	
	@GetMapping("/lista")
	public ModelAndView lista() {
		Iterable<Correntista> correntistas = correntistaRepository.findAll();
		return new ModelAndView("correntista/lista", "correntistas", correntistas);
	}

}
