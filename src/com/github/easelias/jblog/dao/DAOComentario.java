package com.github.easelias.jblog.dao;

import java.util.Date;
import java.util.List;

import com.github.easelias.jblog.model.Comentario;
import com.github.easelias.jblog.model.Post;

public interface DAOComentario {

	public long add(Comentario c) throws DAOException;

	public long update(Comentario c) throws DAOException;

	public long delete(Comentario c) throws DAOException;

	public List<Comentario> listAll() throws DAOException;

	public Comentario getById(long id) throws DAOException;

	public List<Comentario> listByPost(Post p) throws DAOException;
	
	public List<Comentario> searchByDataCriacao(Date dataCriacao) throws DAOException;

}
