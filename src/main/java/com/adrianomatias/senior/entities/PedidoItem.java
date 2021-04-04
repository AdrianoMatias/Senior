package com.adrianomatias.senior.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.adrianomatias.senior.entities.PK.PedidoItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_pedido_item")
public class PedidoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoItemPK id = new PedidoItemPK();
	
	private Integer qtdHora;
	private Double valorHoraServico;
	
	public PedidoItem() {
	}
	
	public PedidoItem(Servico servico, Pedido pedido, Integer qtdHora, Double valorHoraServico) {
		super();
		id.setPedido(pedido);
		id.setServico(servico);
		this.qtdHora = qtdHora;
		this.valorHoraServico = valorHoraServico;
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Servico getServico() {
		return id.getServico();
	}
	
	public void setServico(Servico servico) {
		id.setServico(servico);
	}

	public Integer getQtdHora() {
		return qtdHora;
	}

	public void setQtdHora(Integer qtdHora) {
		this.qtdHora = qtdHora;
	}

	public Double getValorHoraServico() {
		return valorHoraServico;
	}

	public void setValorHoraServico(Double valorHoraServico) {
		this.valorHoraServico = valorHoraServico;
	}
	
	public Double getSubTotal() {
		return qtdHora * valorHoraServico;
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
		PedidoItem other = (PedidoItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
