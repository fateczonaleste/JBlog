package br.jblog.managedBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.jblog.dao.DAOBlogImpl;
import br.jblog.dao.DAOException;
import br.jblog.dao.DAOBlog;
import br.jblog.model.Blog;

@ManagedBean
@RequestScoped
public class BlogMB {
	private Blog blog;
	private List<Blog> blogs;
	private Blog blogSelecionado;

	public BlogMB() {
		blog =  (Blog)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("BLOG"); 
		if(blog == null){
			blogs = new ArrayList<Blog>();
		}
		blogSelecionado = new Blog();
	}

	public Blog getBlogSelecionado() {
		System.out.println("GET selec");
		return blogSelecionado;
		
	}

	public void setBlogSelecionado(Blog blogSelecionado) throws IOException, ServletException {
		this.blogSelecionado = blogSelecionado;
		System.out.println(blogSelecionado);
		blog = blogSelecionado;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("BLOG", blog);
		FacesContext.getCurrentInstance().getExternalContext().redirect("verBlog.jsf");
	}

	public Blog getBlog() {
		return blog;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public String add() {
		DAOBlog dao = new DAOBlogImpl();
		String mensagem;
		try {
			dao.update(blog);
			mensagem = "Salvo com sucesso.";
		} catch (DAOException e) {
			e.printStackTrace();
			mensagem = e.getMessage();
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));

		return mensagem;
	}

	public String deletar() {
		DAOBlog dao = new DAOBlogImpl();
		try {
			dao.delete(blog);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String alterar() {
		DAOBlog dao = new DAOBlogImpl();
		try {
			dao.update(blog);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String selecionar() {
		DAOBlog dao = new DAOBlogImpl();
		try {

			blog = dao.getById(blog.getId());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public List<Blog> consultarTodos() {
		DAOBlog cDao = new DAOBlogImpl();
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
