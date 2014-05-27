package br.jblog.dao;

import java.util.List;

import br.jblog.model.Post;

public interface DaoPost {
	public int add(Post p, double id);
	public boolean update(Post p);
	public boolean delete(Post p);	
	public List<Post> listAll();
	public Post getById(double id);
}
