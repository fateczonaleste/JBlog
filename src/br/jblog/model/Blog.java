package br.jblog.model;


public class Blog {

	private double id;
	private String titulo;
	private String descricao;
	private String meta;
		
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
	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}	
	
	public void addComentario(Comentario c){
		
	}
	
}
