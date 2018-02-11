package com.cubas.bancodopovo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static int CONTABASICA = 1;
	public static int CONTAPREMIUN = 1;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Double saldo;
	
	private int tipoConta = 1;
	
	@OneToMany(mappedBy="conta")
	private List<Historico> historicos = new ArrayList<Historico>();
	
	@ManyToOne
	@JoinColumn(name="id_correntista")
	private Correntista correntista;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Correntista getCorrentista() {
		return correntista;
	}

	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}

	public int getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}

	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}
	
	public String getDescricaoTipoConta(){
		if(this.tipoConta == CONTABASICA){
			return "BÁSICA";
		}else{
			return "PREMIUN";
		}
	}
}
