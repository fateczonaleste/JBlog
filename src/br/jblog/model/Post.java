package br.jblog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

	private double id;
	private String titulo;
	private String conteudo;
	private Date dataCriacao;
	private List<Comentario> comentarios;
	private Usuario usuario;

	public Post() {
		comentarios = new ArrayList<Comentario>();
		usuario = new Usuario();
		usuario.setId(1);
		this.dataCriacao = new Date();
	}

	
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void addComentario(Comentario c) {
		this.comentarios.add(c);
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

	public boolean isPublicado() {
		return isPublicado;
	}

	public void setPublicado(boolean isPublicado) {
		this.isPublicado = isPublicado;
	}

	private boolean isPublicado;

}
