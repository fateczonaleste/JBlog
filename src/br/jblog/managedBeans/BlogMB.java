package br.jblog.managedBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.jblog.dao.DAOBlogImpl;
import br.jblog.dao.DAOException;
import br.jblog.dao.DaoBlog;
import br.jblog.model.Blog;

@ManagedBean
@ViewScoped
@RequestScoped
public class BlogMB {
	private Blog blog;
	private List<Blog> blogs;

	public BlogMB() {
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpSession session = (HttpSession) context.getSession(true);
		blog = (Blog) session.getAttribute("blog");
		if (blog == null) {
			blog = new Blog();
		}
		blogs = new ArrayList<Blog>();

	}

	public Blog getBlog() {
		return blog;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public String adicionar() {
		DaoBlog dao = new DAOBlogImpl();
		try {
			dao.add(blog);
		} catch (DAOException e) {
			e.printStackTrace();
		}

		return "";
	}

	public String deletar() {
		DaoBlog dao = new DAOBlogImpl();
		try {
			dao.delete(blog);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String alterar() {
		DaoBlog dao = new DAOBlogImpl();
		try {
			dao.update(blog);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String selecionar() {
		DaoBlog dao = new DAOBlogImpl();
		try {

			blog = dao.getById(blog.getId());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public List<Blog> consultarTodos() {
		DaoBlog cDao = new DAOBlogImpl();
		try {
			blogs = cDao.listAll();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return blogs;
	}

	public void blogSession() throws IOException, ServletException {
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpSession session = (HttpSession) context.getSession(true);
		session.setAttribute("blog", blog);
		HttpServletResponse res = (HttpServletResponse) context.getResponse();
		res.sendRedirect("verBlog.jsp");
	}

}
