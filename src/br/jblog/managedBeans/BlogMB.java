package br.jblog.managedBeans;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.jblog.dao.DAOBlog;
import br.jblog.dao.DAOBlogImpl;
import br.jblog.dao.DAOException;
import br.jblog.model.Blog;

@ManagedBean
@ViewScoped
@RequestScoped
public class BlogMB {
	
	private Blog blog;	

	public BlogMB() {
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpSession session = (HttpSession) context.getSession(true);
		blog = (Blog) session.getAttribute("blog");
		if (blog == null) {
			blog = new Blog();
		}
		
	}

	public Blog getBlog() {
		return blog;
	}

	public String salvar() {
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

	public void blogSession() throws IOException, ServletException {
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpSession session = (HttpSession) context.getSession(true);
		session.setAttribute("blog", blog);
		HttpServletResponse res = (HttpServletResponse) context.getResponse();
		res.sendRedirect("verBlog.jsp");
	}

}
