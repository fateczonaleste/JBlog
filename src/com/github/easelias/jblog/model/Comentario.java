package com.github.easelias.jblog.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comentario {

	@Id
	@GeneratedValue
	private long id;

	@Temporal(TemporalType.DATE)
	private Date dataCriacao;

	@Column(length = 100)
	private String nome;

	@Column(length = 180)
	private String conteudo;

	@Column(length = 100)
	private String email;

	@ManyToOne
	private Post post;
	
	public Comentario() {
		this.setPost(new Post());
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public boolean equals(Comentario c) {
		boolean isEqual = false;
		if (this.getId() == c.getId()) {
			isEqual = true;
		}
		return isEqual;
	}

}
