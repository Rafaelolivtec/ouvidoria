package com.ouvidoria1.spring.Ouvidoria1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouvidoria1.spring.Ouvidoria1.entities.Aluno;
import com.ouvidoria1.spring.Ouvidoria1.entities.Funcionario;
import com.ouvidoria1.spring.Ouvidoria1.entities.Manifestacao;
import com.ouvidoria1.spring.Ouvidoria1.entities.Pessoas;
import com.ouvidoria1.spring.Ouvidoria1.repository.ManifestacaoRepository;
import com.ouvidoria1.spring.Ouvidoria1.repository.PessoasRepository;

@Service
public class PessoasServices {

	@Autowired
	PessoasRepository pessoasRepositories;
	
	@Autowired
	ManifestacaoRepository manifestacaoRepositories;

	public void addUsuario(String nome, String email, String usuario, String senha, boolean numeroVip) {
		Aluno p = new Aluno(nome, email, usuario, senha, false);
		pessoasRepositories.save(p);
	}

	public void addFuncionario(String nome, String email, String usuario, String senha, boolean numeroVip) {
		Funcionario p = new Funcionario(nome, email, usuario, senha, true);
		pessoasRepositories.save(p);
	}

	public Pessoas logarAluno(String usuario, String senha) {
		for (Pessoas p : pessoasRepositories.findAll()) {
			if (p.getUsuario().equals(usuario) && p.getSenha().equals(senha)) {
				return p;
			}
		}
		return null;
	}
	
	public Pessoas logarFuncionario(String usuario, String senha) {
		for (Pessoas p : pessoasRepositories.findAll()) {
			if (p.getUsuario().equals(usuario) && p.getSenha().equals(senha) && p.isNumeroVip()) {
				return p;
			}
		}
		return null;
	}
	
	public void adicionarManifestacao(String tipo, String texto, Pessoas usuario) {
		Manifestacao p = new Manifestacao(usuario, tipo, texto);
		manifestacaoRepositories.save(p);
	}
	
	public void listarManifestacao() {
		for (Manifestacao p : manifestacaoRepositories.findAll()) {
			System.out.println("\nId: " + p.getId());
			System.out.println("Usuário: " + p.getUsuario());
			System.out.println("Tipo: " + p.getTipo());
			System.out.println("Descricao: " + p.getDescricao());
		}
	}
	
	public void removerManifestacao(Long id) {
		manifestacaoRepositories.deleteById(id);
	}
}
