package br.jblog.dao;

import java.util.List;

import br.jblog.model.Usuario;

public interface DaoUsuario {
	public int add(Usuario u) throws DAOException;
	public int update(Usuario u) throws DAOException;
	public int delete(Usuario u) throws DAOException;	
	public List<Usuario> listAll() throws DAOException;
	public Usuario getById(double id) throws DAOException;
	public List<Usuario> searchByNome(String nome) throws DAOException;
}
