package com.github.easelias.jblog.dao;

import com.github.easelias.jblog.model.Blog;

public interface DAOBlog {
	
	public void save(Blog b) throws DAOException;		
	public Blog getBlog() throws DAOException;

}
