package com.adrianomatias.senior.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String servicoComercializado;
	private String qtdHora;
	private String profissionalAlocado;
	private String procentagemImposto;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Servico pedido;
	
	public Pedido() {}

	public Pedido(Long id, String servicoComercializado, String qtdHora, String profissionalAlocado,
			      String procentagemImposto, Servico pedido) {
		super();
		Id = id;
		this.servicoComercializado = servicoComercializado;
		this.qtdHora = qtdHora;
		this.profissionalAlocado = profissionalAlocado;
		this.procentagemImposto = procentagemImposto;
		this.pedido = pedido;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getServicoComercializado() {
		return servicoComercializado;
	}

	public void setServicoComercializado(String servicoComercializado) {
		this.servicoComercializado = servicoComercializado;
	}

	public String getQtdHora() {
		return qtdHora;
	}

	public void setQtdHora(String qtdHora) {
		this.qtdHora = qtdHora;
	}

	public String getProfissionalAlocado() {
		return profissionalAlocado;
	}

	public void setProfissionalAlocado(String profissionalAlocado) {
		this.profissionalAlocado = profissionalAlocado;
	}

	public String getProcentagemImposto() {
		return procentagemImposto;
	}

	public void setProcentagemImposto(String procentagemImposto) {
		this.procentagemImposto = procentagemImposto;
	}

	public Servico getPedido() {
		return pedido;
	}

	public void setPedido(Servico pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
	
}
