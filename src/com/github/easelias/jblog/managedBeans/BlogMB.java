package com.github.easelias.jblog.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.github.easelias.jblog.dao.DAOBlog;
import com.github.easelias.jblog.dao.DAOBlogImpl;
import com.github.easelias.jblog.dao.DAOException;
import com.github.easelias.jblog.model.Blog;

@ManagedBean
@RequestScoped
public class BlogMB {

	private Blog blog;

	public BlogMB() {

		this.blog = new Blog();
		
		try {
			DAOBlog dao = new DAOBlogImpl();
			this.blog = dao.getBlog();							
		} catch (DAOException e) {
			showMessage(e.getMessage());
		}

	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public void showMessage(String message) {

	}

	public void salvar() {
		try {
			DAOBlog dao = new DAOBlogImpl();
			dao.save(blog);
		} catch (DAOException e) {
			showMessage(e.getMessage());
		}
	}

	public void cancelar() {
		// TODO: mandar para a pagina admin principal
	}

}
