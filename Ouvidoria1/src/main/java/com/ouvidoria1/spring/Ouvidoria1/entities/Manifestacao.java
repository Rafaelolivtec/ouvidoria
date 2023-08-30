package com.ouvidoria1.spring.Ouvidoria1.entities;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Manifestacao {

	@ManyToOne
	@JoinColumn(nullable = false)
	private Pessoas usuario;
	private String tipo;
	private String descricao;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Manifestacao() {
		
	}
	public Manifestacao(Pessoas usuario, String tipo, String descricao) {
		super();
		this.usuario = usuario;
		this.tipo = tipo;
		this.descricao = descricao;
		this.id = id;
	}

	public Pessoas getUsuario() {
		return usuario;
	}

	public void setUsuario(Pessoas usuario) {
		this.usuario = usuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
