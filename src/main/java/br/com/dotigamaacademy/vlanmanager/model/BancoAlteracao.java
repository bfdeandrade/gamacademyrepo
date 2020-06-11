package br.com.dotigamaacademy.vlanmanager.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_banco_mudanca")
public class BancoAlteracao {
	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="vlan_anterior", length=11)
	private String vlanOld;
	@Column(name="vlan_atual", length=11)
	private String vlanNew;
	@ManyToOne
	@JsonIgnoreProperties("bancoAlteracao")
	private Usuario usuario;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVlanOld() {
		return vlanOld;
	}
	public void setVlanOld(String vlanOld) {
		this.vlanOld = vlanOld;
	}
	public String getVlanNew() {
		return vlanNew;
	}
	public void setVlanNew(String vlanNew) {
		this.vlanNew = vlanNew;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
