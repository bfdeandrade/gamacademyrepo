package br.com.dotigamaacademy.vlanmanager.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.dotigamaacademy.vlanmanager.model.BancoAlteracao;
import br.com.dotigamaacademy.vlanmanager.model.Departamento;

public interface BancoAlteracaoDAO extends CrudRepository<BancoAlteracao, Integer>{

}
