package com.prueba.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.modelo.Reporte;
import com.prueba.modelo.Usuario;
import com.prueba.repository.Repository;
import com.prueba.repository.UsuarioRepository;


@RestController
@RequestMapping({"crud"})
public class Controller {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private Repository reporteRepository;
	
	@GetMapping("listar")
	public List<Usuario> listarUsuarios(){
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
		return usuarios;
	}
	
	@GetMapping("/{id}")
	public Optional<Usuario> listarReporteByUsuario(@PathVariable int id){
		
		Optional<Usuario> reporte = (Optional<Usuario>) usuarioRepository.findById(id);
		return reporte;
	}
	
	@PostMapping
	public Usuario postUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);		
	}
	
	@PostMapping("/reporte")
	public Reporte postReporte(@RequestBody Reporte reporte) {
		return reporteRepository.save(reporte);		
	}
	
	
}
