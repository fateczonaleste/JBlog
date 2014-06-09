package com.github.easelias.jblog.model;

import java.util.Date;

public class Post {


	private double id;
	
	
	private String titulo;
	private String conteudo;
	

	private Date dataCriacao;

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

	public double getId() {
		return id;
	}

	public void setId(double id) {
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

}
