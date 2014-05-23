package br.jblog.dao;

import java.util.List;

import br.jblog.model.Blog;

public interface DaoBlog {
	
	public int add(Blog b);
	public boolean update(Blog b);
	public boolean delete(Blog b);	
	public List<Blog> listAll();
	public Blog getById(double id);
		
}
