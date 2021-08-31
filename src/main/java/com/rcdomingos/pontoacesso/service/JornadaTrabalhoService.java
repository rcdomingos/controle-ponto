package com.rcdomingos.pontoacesso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcdomingos.pontoacesso.JornadaTrabalhoRepository;
import com.rcdomingos.pontoacesso.model.JornadaTrabalho;

@Service
public class JornadaTrabalhoService {

	@Autowired
	JornadaTrabalhoRepository jornadaTrabalhoRepository;

	public JornadaTrabalho inserir(JornadaTrabalho jornada) {
		return jornadaTrabalhoRepository.save(jornada);
	}
	
	public List<JornadaTrabalho> listarProdutos(){
		return jornadaTrabalhoRepository.findAll();
	}
	
	public Optional<JornadaTrabalho> listarPeloId(Long id) {
		return jornadaTrabalhoRepository.findById(id);
	}
	
	public void deletarJornada(Long id) {
		try {
			jornadaTrabalhoRepository.deleteById(id);
		}catch (Exception e) {
			
		}
	}
	
}
