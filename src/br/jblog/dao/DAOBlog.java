package br.jblog.dao;

import java.util.List;

import br.jblog.model.Blog;

public interface DAOBlog {
	
	public int add(Blog b) throws DAOException;
	public int update(Blog b) throws DAOException;
	public int delete(Blog b) throws DAOException;
	public List<Blog> listAll() throws DAOException;
	public Blog getById(double id) throws DAOException;

}
