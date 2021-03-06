package br.com.dotigamaacademy.vlanmanager.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.dotigamaacademy.vlanmanager.dao.DepartamentoDAO;
import br.com.dotigamaacademy.vlanmanager.model.Departamento;

@RestController
@CrossOrigin("*")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoDAO dao;
	
	// metodo para buscar todos os departamentos
	@GetMapping("/departamentos")
	public ArrayList<Departamento> buscarTodos(){
		ArrayList<Departamento> lista;
		lista = (ArrayList<Departamento>)dao.findAll();
		return lista;
	}
	
	// metodo para buscar detalhes de 1 unico departamento
	@GetMapping("/departamentos/{id}")
	public ResponseEntity<Departamento> buscarPorId(@PathVariable int id){
		Departamento depto = dao.findById(id).orElse(null);
		if (depto != null) {
			return ResponseEntity.ok(depto);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
