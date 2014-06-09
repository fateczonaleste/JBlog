package com.github.easelias.jblog.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	@Column
	private Long id;

	@Basic(optional = false)
	@Column
	private String nome;

	@NaturalId
	@Basic(optional = false)
	@Column
	private String login;
	@Basic(optional = false)
	@Column
	private String senha;

	@Basic(optional = true)
	@Column
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

}
