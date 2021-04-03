package com.adrianomatias.senior.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeServico;
	private Double valorHoraServico;
	
	@OneToMany(mappedBy = "pedido")
	private List<Pedido> pedidos = new ArrayList<>();

	public Servico() {
	}

	public Servico(Long id, String nomeServico, Double valorHoraServico) {
		super();
		this.id = id;
		this.nomeServico = nomeServico;
		this.valorHoraServico = valorHoraServico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public Double getValorHoraServico() {
		return valorHoraServico;
	}

	public void setValorHoraServico(Double valorHoraServico) {
		this.valorHoraServico = valorHoraServico;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Servico other = (Servico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
