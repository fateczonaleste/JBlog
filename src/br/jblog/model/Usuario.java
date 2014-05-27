package br.jblog.model;

public class Usuario {

	private double id;
	private String nome;
	private String login;
	private String senha;
	private String bio;

	public double getId() {
		return id;
	}

	public void setId(double id) {
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

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public Usuario logar(Usuario usuario){
		
		return usuario;
		
	}

}
