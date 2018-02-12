package com.cubas.bancodopovo.model;

import java.util.ArrayList;
import java.util.List;

public class AjaxResponseBody {
	
	Double valorTotal;
	
	Long id;
	
	List<Historico> historicos = new ArrayList<>();
	
	

	public AjaxResponseBody(Long id, Double valorTotal, List<Historico> historicos) {
		super();
		this.valorTotal = valorTotal;
		this.id = id;
		this.historicos = historicos;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
