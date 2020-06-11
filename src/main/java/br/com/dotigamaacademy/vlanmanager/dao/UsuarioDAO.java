package br.com.dotigamaacademy.vlanmanager.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.dotigamaacademy.vlanmanager.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	public Usuario findByEmailAndSenha(String email, String senha);
	public Usuario findByRacfAndSenha(String racf, String senha);
	public Usuario findByEmail(String email);
}
