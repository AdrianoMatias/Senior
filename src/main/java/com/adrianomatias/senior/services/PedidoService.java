package com.adrianomatias.senior.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianomatias.senior.entities.Pedido;
import com.adrianomatias.senior.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.get();
	}
	
	public Pedido insert(Pedido obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
