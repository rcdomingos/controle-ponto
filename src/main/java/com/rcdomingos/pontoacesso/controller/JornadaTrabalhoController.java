package com.rcdomingos.pontoacesso.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rcdomingos.pontoacesso.model.JornadaTrabalho;
import com.rcdomingos.pontoacesso.service.JornadaTrabalhoService;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

	@Autowired
	JornadaTrabalhoService service;

	@PostMapping
	ResponseEntity<JornadaTrabalho> adicionaJornada(@RequestBody JornadaTrabalho jornada) {
		JornadaTrabalho result = service.inserir(jornada);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
		return ResponseEntity.created(uri).body(result);
	}

	@GetMapping
	public ResponseEntity<List<JornadaTrabalho>> listaTodosProdutos() {
		List<JornadaTrabalho> result = service.listarProdutos();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<JornadaTrabalho> listaJornadaPeloId(@PathVariable Long id) {
		Optional<JornadaTrabalho> result = service.listarPeloId(id);
		
		if (result.isPresent()) {
			return ResponseEntity.ok().body(result.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarJornada(@PathVariable Long id) {
		service.deletarJornada(id);
		return ResponseEntity.ok().build();
	}

}
