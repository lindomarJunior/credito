package com.credito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credito.calculador.Calculador;
import com.credito.domain.Cliente;
import com.credito.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@PostMapping("/salva")
	public void salvarCliente(@RequestBody Cliente cliente) {	
		
		Calculador calculador = new Calculador(cliente);
		cliente = calculador.calcularAnalise();			
		clienteRepository.save(cliente);
	}
}
