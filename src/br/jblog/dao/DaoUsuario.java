package br.jblog.dao;

import java.util.List;

import br.jblog.model.Usuario;

public interface DaoUsuario {
	public int add(Usuario u);
	public boolean update(Usuario u);
	public boolean delete(Usuario u);	
	public List<Usuario> listAll();
	public Usuario getById(double id);
}
