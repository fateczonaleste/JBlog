package br.jblog.model;

public class Blog {

	private double id;
	private String titulo;
	private String descricao;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
