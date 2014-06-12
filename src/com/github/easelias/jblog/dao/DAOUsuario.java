package com.github.easelias.jblog.dao;

import java.util.List;

import com.github.easelias.jblog.model.Usuario;

public interface DAOUsuario {
	public long add(Usuario u) throws DAOException;

	public long update(Usuario u) throws DAOException;

	public long delete(Usuario u) throws DAOException;

	public List<Usuario> listAll() throws DAOException;

	public Usuario getById(long id) throws DAOException;

	public List<Usuario> searchByNome(String nome) throws DAOException;
}
