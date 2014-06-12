package com.github.easelias.jblog.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 100)
	private String nome;

	@Column(length = 20)
	private String login;

	@Column(length = 32)
	private String senha;

	@Column(length = 180)
	@Basic (optional=true)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String bio) {
		this.descricao = bio;
	}
	
	public boolean equals(Usuario u) {
		boolean isEqual = false;
		if (this.getId() == u.getId()) {
			isEqual = true;
		}
		return isEqual;
	}

}
