package com.adrianomatias.senior.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.adrianomatias.senior.entities.Pedido;
import com.adrianomatias.senior.entities.PedidoItem;
import com.adrianomatias.senior.entities.Servico;
import com.adrianomatias.senior.repositories.PedidoItemRepository;
import com.adrianomatias.senior.repositories.PedidoRepository;
import com.adrianomatias.senior.repositories.ServicoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoItemRepository pedidoItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Servico s1 = new Servico(null, "Tecnologia", 10.0);
		Servico s2 = new Servico(null, "Manutenção de Computadores", 20.00);
		
		Pedido p1 = new Pedido(null, "Desenvolvimento de Sistemas", 2, "Adriano Matias", 20.0, s1);
		Pedido p2 = new Pedido(null, "Troca de memória", 2, "Antonio Souza", 10.0, s2);
		Pedido p3 = new Pedido(null, "Desenvolvimento Front End", 6, "Bruno Ferreira", 15.0, s1);
		
		servicoRepository.saveAll(Arrays.asList(s1, s2));
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		PedidoItem pi1 = new PedidoItem(s1, p1, 2, p1.getServico().getValorHoraServico());
		PedidoItem pi2 = new PedidoItem(s1, p3, 1, p3.getServico().getValorHoraServico());
		PedidoItem pi3 = new PedidoItem(s2, p3, 5, p2.getServico().getValorHoraServico());
		PedidoItem pi4 = new PedidoItem(s1, p2, 6, p1.getServico().getValorHoraServico());
		
		
		pedidoItemRepository.saveAll(Arrays.asList(pi1,pi2,pi3, pi4));
		
	}
}
