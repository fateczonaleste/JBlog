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
import br.jblog.dao.DaoBlog;
import br.jblog.model.Blog;

@ManagedBean
@ViewScoped
@RequestScoped
public class BlogMB {
	private Blog blog;
	private List<Blog> blogs;

	public BlogMB() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) context.getSession(true);
		blog = (Blog) session.getAttribute("blog");
		if (blog == null) {
			blog = new Blog();
		}
		System.out.println(blog.getTitulo());
		blogs = new ArrayList<Blog>();
		
		blog.setId(1);
		blog.setTitulo("JSF com Primer Faces");
		blog.setDescricao("Será apresentado nesse curso de JSF como utilizar o Java Server Faces 2.0 em conjunto com a suíte de componentes do PrimeFaces, uma poderosa biblioteca para o desenvolvimento de aplicações, tornando o ambiente de desenvolvimento mais produtivo, com aplicações mais ricas visualmente e com maior usabilidade, além de funcionalidades para realizar requisições assíncrona, melhorando assim a experiência do usuário com o seu sistema. Passaremos por todas as etapas, como download da ide, e configuração da mesma para trabalhar com o tomcat 7 e jsf 2.0, evitando assim deixar arestas para aqueles que estão iniciando e com a preocupação de atender as exigências de usuários com maior familiaridade e experiência com a plataforma.");
	}

	public Blog getBlog() {
		return blog;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public String adicionar() {
		DaoBlog dao = new DAOBlogImpl();
		System.out.println(blog.getTitulo());
		dao.add(blog);
		return "";
	}

	public String deletar() {
		DaoBlog dao = new DAOBlogImpl();
		System.out.println(blog.getTitulo());
		dao.delete(blog);
		return "";
	}

	public String alterar() {
		DaoBlog dao = new DAOBlogImpl();
		dao.update(blog);
		return "";
	}

	public String selecionar() {
		DaoBlog dao = new DAOBlogImpl();
		blog = dao.getById(blog.getId());
		return "";
	}

	public List<Blog> consultarTodos() {
		DaoBlog cDao = new DAOBlogImpl();
		blogs = cDao.listAll();
		return blogs;
	}

	public void blogSession() throws   IOException, ServletException {
		ExternalContext context = FacesContext.getCurrentInstance()	.getExternalContext();
		HttpSession session = (HttpSession) context.getSession(true);
		session.setAttribute("blog", blog);
		HttpServletResponse res = (HttpServletResponse) context.getResponse();
		System.out.println("Passou");
		res.sendRedirect("verBlog.jsp");
	}

}
