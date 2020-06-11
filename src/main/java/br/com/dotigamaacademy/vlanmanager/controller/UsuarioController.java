package br.com.dotigamaacademy.vlanmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dotigamaacademy.vlanmanager.dao.UsuarioDAO;
import br.com.dotigamaacademy.vlanmanager.model.BancoAlteracao;
import br.com.dotigamaacademy.vlanmanager.model.Usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios")
	public ArrayList<Usuario> listarTodos(){
		return (ArrayList<Usuario>)dao.findAll();
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> logarUsuario(@RequestBody Usuario dadosLogin) {		
		Usuario res = dao.findByEmail(dadosLogin.getEmail());
	    if (res != null) {  // o usuario existe!!!
	    	if (res.getSenha().equals(dadosLogin.getSenha())) {
	    	   res.setSenha("****");
 	    	   return ResponseEntity.ok(res);
	    	}
	    	else {
	    	   return ResponseEntity.status(403).build();
	    	}
	    }
	    else {     // o usuario NÃO existe!!!
	    	return ResponseEntity.status(404).build();
	    }
	
	}
	
	@PutMapping("/usuario/update")
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario novosDados){
		try {
			dao.save(novosDados);
			return ResponseEntity.ok(novosDados);
		}
		catch(Exception ex) {
			return ResponseEntity.status(400).build();
		}
	}
	@GetMapping("/usuario/alteracao/{id}")
	public List<BancoAlteracao> listarAlteracoes(@PathVariable int id){
		Usuario user = dao.findById(id).orElse(null);
		if(user != null) {
			return user.getBancoAlteracao();
		} else {
			return null;
		}
	}
}




