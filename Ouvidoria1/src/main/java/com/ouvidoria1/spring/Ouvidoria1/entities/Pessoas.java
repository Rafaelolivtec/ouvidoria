package com.ouvidoria1.spring.Ouvidoria1.entities;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "tipo")
public class Pessoas {

	private String nome;
	private String email;
	private String usuario;
	private String senha;
	private boolean numeroVip;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Pessoas() {

	}

	public Pessoas(String nome, String email, String usuario, String senha, boolean numeroVip) {
		super();
		this.nome = nome;
		this.email = email;
		this.usuario = usuario;
		this.senha = senha;
		this.numeroVip = numeroVip;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isNumeroVip() {
		return numeroVip;
	}

	public void setNumeroVip(boolean numeroVip) {
		this.numeroVip = numeroVip;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
