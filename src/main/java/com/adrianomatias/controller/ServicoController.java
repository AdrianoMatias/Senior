package com.adrianomatias.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.adrianomatias.senior.entities.Servico;

@Controller
@RequestMapping("http://localhost:8080/servicos")
public class ServicoController {

	@CrossOrigin
	@GetMapping
	public String index(Model model) {
		RestTemplate api = new RestTemplate();
        List<?> servicos = api.getForObject("http://localhost:8080/servicos", List.class);
        model.addAttribute("servicos", servicos);
        return "servicos/servicos";
	}
	
	@PostMapping("http://localhost:8080/servicos/cadastrar")
    public String insert(Servico servico, RedirectAttributes redirectAttributes) {
        RestTemplate api = new RestTemplate();
        Servico servicoResultado = api.postForObject("http://localhost:8080/servicos", servico, Servico.class);
        redirectAttributes.addFlashAttribute("msg", String.format("Serviço \"%s\" cadastrada com sucesso.",
                servicoResultado.getNomeServico()));
        return "redirect:/pedidos";
    }
	
}
