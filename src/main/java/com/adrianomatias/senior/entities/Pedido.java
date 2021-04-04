package com.adrianomatias.senior.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String servicoComercializado;
	private Integer qtdHora;
	private String profissionalAlocado;
	private double porcentagemImposto;
	private double lucro;
	private double total;
	
	@ManyToOne
	@JoinColumn(name = "servico_id")
	private Servico servico;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<PedidoItem> items = new HashSet<>();
	
	public Pedido() {}

	public Pedido(Long id, String servicoComercializado, Integer qtdHora, String profissionalAlocado, Double porcentagemImposto, Servico servico) {
		super();
		this.Id = id;
		this.servicoComercializado = servicoComercializado;
		this.qtdHora = qtdHora;
		this.profissionalAlocado = profissionalAlocado;
		this.porcentagemImposto = porcentagemImposto;
		this.servico = servico;
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

	public Integer getQtdHora() {
		return qtdHora;
	}

	public void setQtdHora(Integer qtdHora) {
		this.qtdHora = qtdHora;
	}

	public String getProfissionalAlocado() {
		return profissionalAlocado;
	}

	public void setProfissionalAlocado(String profissionalAlocado) {
		this.profissionalAlocado = profissionalAlocado;
	}

	public Double getPorcentagemImposto() {
		return porcentagemImposto;
	}
	
	public void setPorcentagemImposto(Double porcentagemImposto) {
		this.porcentagemImposto = porcentagemImposto;
	}
	
	/*public Double getLucro() {
		double receitaTotal;
		double custo;
		double percentualLucro = porcentagemImposto / 100;
		receitaTotal = servico.getValorHoraServico() * qtdHora;
		custo = receitaTotal - (percentualLucro * receitaTotal);
		lucro = (custo/receitaTotal) * 100;
		return lucro;
	}*/

	public void setLucro(Double lucro) {
		this.lucro = lucro;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Set<PedidoItem> getItems() {
		return items;
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for(PedidoItem x : items) {
			double pencentual = porcentagemImposto / 100;
			sum += x.getSubTotal();
		}
		return sum;
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
