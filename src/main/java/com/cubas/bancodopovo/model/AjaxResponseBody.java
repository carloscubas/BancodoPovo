package com.cubas.bancodopovo.model;

import java.util.ArrayList;
import java.util.List;

public class AjaxResponseBody {
	
	Double valorTotal;
	
	List<Historico> historicos = new ArrayList<>();
	
	

	public AjaxResponseBody(Double valorTotal, List<Historico> historicos) {
		super();
		this.valorTotal = valorTotal;
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
	
	

}
