package br.jblog.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.jblog.dao.DaoBlog;
import br.jblog.model.Blog;


@WebServlet("/servletBlog")
public class servletBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servletBlog() {
        super();

    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		if("Inserir".equals(cmd)){
			Blog b = new Blog();
			b.setDescricao(req.getParameter("descricao"));
			b.setId(Double.parseDouble(req.getParameter("id")));
			b.setMeta(req.getParameter("meta"));
			b.setTitulo(req.getParameter("titulo"));
			DaoBlog d = new DaoBlog();
			boolean ver = d.inserir(b);
			if(ver){
				PrintWriter out = res.getWriter();
				out.println("Sucesso");
			}else{
				PrintWriter out = res.getWriter();
				out.println("Fracasso");
			}
		}
		
		if("Consultar".equals(cmd)){
			DaoBlog b = new DaoBlog();
			Blog blog = new Blog();
			blog.setId(Double.parseDouble(req.getParameter("id")));
			blog = b.selecionar(blog.getId());
			PrintWriter out = res.getWriter();
			out.println(blog.getTitulo());
		}
		
		if("Deletar".equals(cmd)){
			DaoBlog d = new DaoBlog();
			boolean ver = d.deletar(Double.parseDouble(req.getParameter("id")));
			if(ver){
				PrintWriter out = res.getWriter();
				out.println("Sucesso");
			}else{
				PrintWriter out = res.getWriter();
				out.println("Fracasso");
			}
		}
		if("Alterar".equals(cmd)){
			Blog b = new Blog();
			b.setDescricao(req.getParameter("descricao"));
			b.setId(Double.parseDouble(req.getParameter("id")));
			b.setMeta(req.getParameter("meta"));
			b.setTitulo(req.getParameter("titulo"));
			DaoBlog d = new DaoBlog();
			boolean ver = d.alterar(b);
			if(ver){
				PrintWriter out = res.getWriter();
				out.println("Sucesso");
			}else{
				PrintWriter out = res.getWriter();
				out.println("Fracasso");
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

