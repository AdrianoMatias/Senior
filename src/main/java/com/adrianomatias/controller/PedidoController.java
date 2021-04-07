package com.adrianomatias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.adrianomatias.senior.entities.Servico;

@Controller
@RequestMapping("http://localhost:8080/pedidos")
public class PedidoController {
	
	@PostMapping("/cadastrar")
    public String insert(Servico servico, RedirectAttributes redirectAttributes) {
        RestTemplate api = new RestTemplate();
        Servico servicoResultado = api.postForObject("http://localhost:8080/pedidos", servico, Servico.class);
        redirectAttributes.addFlashAttribute("msg", String.format("Serviço \"%s\" cadastrada com sucesso.",
                servicoResultado.getNomeServico()));
        return "redirect:/pedidos/pedidos";
    }
	
}
