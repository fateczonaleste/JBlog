package com.github.easelias.jblog.dao;

import java.util.List;

import com.github.easelias.jblog.model.Usuario;

public interface DAOUsuario {
	public Long add(Usuario u) throws DAOException;

	public Long update(Usuario u) throws DAOException;

	public Long delete(Usuario u) throws DAOException;

	public List<Usuario> listAll() throws DAOException;

	public Usuario getById(double id) throws DAOException;

	public List<Usuario> searchByNome(String nome) throws DAOException;
}
