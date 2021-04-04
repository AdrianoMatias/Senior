package com.adrianomatias.senior.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrianomatias.senior.entities.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long>{

}
