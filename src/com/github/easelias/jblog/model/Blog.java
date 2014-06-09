package com.github.easelias.jblog.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Blog {
	
	@Column
	@Basic(optional = false)
	private String titulo;
	
	@Column
	@Basic(optional = true)
	private String descricao;
		
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
