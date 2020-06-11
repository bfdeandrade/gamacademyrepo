package br.com.dotigamaacademy.vlanmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.dotigamaacademy.vlanmanager.model.BancoAlteracao;
import br.com.dotigamaacademy.vlanmanager.model.Departamento;
import br.com.dotigamaacademy.vlanmanager.model.Usuario;
import br.com.dotigamaacademy.vlanmanager.dao.BancoAlteracaoDAO;
import br.com.dotigamaacademy.vlanmanager.dao.DepartamentoDAO;

@RestController
@CrossOrigin("*")
public class BancoAlteracaoController {
	
	@Autowired
	private BancoAlteracaoDAO dao;
	
	@GetMapping("/bancoalteracao")
	public List<BancoAlteracao> buscarTodos(){
		List<BancoAlteracao> lista;
		lista = (List<BancoAlteracao>)dao.findAll();
		return lista;
	}
	@GetMapping("/bancoalteracao/{id}")
	public ResponseEntity<BancoAlteracao> buscarPorId(@PathVariable int id){
		BancoAlteracao alteracao = dao.findById(id).orElse(null);
		if (alteracao != null) {
			return ResponseEntity.ok(alteracao);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
