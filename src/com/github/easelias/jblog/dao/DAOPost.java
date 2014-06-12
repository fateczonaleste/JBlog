package com.github.easelias.jblog.dao;

import java.util.Date;
import java.util.List;

import com.github.easelias.jblog.model.Post;

public interface DAOPost {

	public long add(Post p) throws DAOException;

	public long update(Post p) throws DAOException;

	public long delete(Post p) throws DAOException;

	public List<Post> listAll() throws DAOException;

	public Post getById(long id) throws DAOException;

	public List<Post> searchByTitulo(String titulo) throws DAOException;

	public List<Post> searchByDataCriacao(Date dataCriacao) throws DAOException;

}
