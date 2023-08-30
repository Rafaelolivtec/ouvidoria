package com.ouvidoria1.spring.Ouvidoria1.entities;

import jakarta.persistence.Entity;

@Entity
public class Aluno extends Pessoas {

	public Aluno() {

	}

	public Aluno(String nome, String email, String usuario, String senha, boolean numeroVip) {
		super(nome, email, usuario, senha, false);
	}

}
