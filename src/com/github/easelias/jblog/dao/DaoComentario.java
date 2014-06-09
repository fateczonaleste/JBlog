package com.github.easelias.jblog.dao;

import java.util.List;

import com.github.easelias.jblog.model.Comentario;
import com.github.easelias.jblog.model.Post;

public interface DaoComentario {
	
	public int add(Comentario c, double id);
	public boolean update(Comentario c);
	public boolean delete(Comentario c);	
	public List<Comentario> listAll();
	public Comentario getById(double id);
	public List<Comentario> listByPost(Post p);

}