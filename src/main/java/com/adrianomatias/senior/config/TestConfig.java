package com.adrianomatias.senior.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.adrianomatias.senior.entities.Pedido;
import com.adrianomatias.senior.entities.Servico;
import com.adrianomatias.senior.repositories.PedidoRepository;
import com.adrianomatias.senior.repositories.ServicoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Servico s1 = new Servico(null, "Tecnologia", 300.00);
		Servico s2 = new Servico(null, "Manutenção de Computadores", 200.00);
		
		Pedido p1 = new Pedido(null, "Desenvolvimento de Sistemas", 100, "Adriano Matias", 20.0, 6000.00, 36000.00, s1);
		Pedido p2 = new Pedido(null, "Troca de memória", 2, "Antonio Souza", 10.0, 40.00, 440.00, s2);
		Pedido p3 = new Pedido(null, "Desenvolvimento Front End", 50, "Bruno Ferreira", 15.0, 2.250, 17250.00, s1);
		
		servicoRepository.saveAll(Arrays.asList(s1, s2));
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}
}
