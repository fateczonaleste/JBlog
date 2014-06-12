package com.github.easelias.jblog.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private long id;

	@Column
	@Basic(optional = false)
	private String titulo;

	@Column
	@Basic(optional = false)
	private String conteudo;

	@Column
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;

	@ManyToOne
	private Usuario autor;

	public Post() {
		setAutor(new Usuario());
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public java.util.Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public boolean equals(Post p) {
		boolean isEqual = false;
		if (this.getId() == p.getId()) {
			isEqual = true;
		}
		return isEqual;
	}

}
