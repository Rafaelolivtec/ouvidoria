package com.ouvidoria1.spring.Ouvidoria1.entities;

import jakarta.persistence.Entity;

@Entity
public class Funcionario extends Pessoas {
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome, String email, String usuario, String senha, boolean numeroVip) {
		super(nome, email, usuario, senha, true);
		this.setNumeroVip(numeroVip);
	}

}
