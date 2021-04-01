package com.adrianomatias.senior.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrianomatias.senior.entities.Servicos;

@RestController
@RequestMapping(value = "/servicos")
public class ServicosResource {
	
	@GetMapping
	public ResponseEntity<Servicos> findAll() {
		Servicos s = new Servicos(1L, "Tecnologia", 250.00);
		return ResponseEntity.ok().body(s);
	}
}
