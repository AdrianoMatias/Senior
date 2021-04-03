package com.adrianomatias.senior.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.adrianomatias.senior.entities.Servico;
import com.adrianomatias.senior.repositories.ServicoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ServicoRepository servicoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Servico s1 = new Servico(null, "Tecnologia", 300.00);
		Servico s2 = new Servico(null, "Manutenção de Computadores", 200.00);
		
		servicoRepository.saveAll(Arrays.asList(s1, s2));
	}
	
	
}
