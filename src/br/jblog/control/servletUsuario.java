package br.jblog.control;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.jblog.dao.DaoUsuario;
import br.jblog.model.Usuario;

@WebServlet("/servletUsuario")
public class servletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		if("Inserir".equals(cmd)){
			Usuario u = new Usuario();
			u.setBio(req.getParameter("bio"));
			u.setId(Integer.parseInt(req.getParameter("id")));
			u.setLogin(req.getParameter("login"));
			u.setNome(req.getParameter("nome"));
			u.setSenha(req.getParameter("senha"));
			DaoUsuario d = new DaoUsuario();
			boolean ver = d.inserir(u);
			if(ver){
				PrintWriter out = res.getWriter();
				out.println("Sucesso");
			}else{
				PrintWriter out = res.getWriter();
				out.println("Fracasso");
			}
		}
		
		if("Consultar".equals(cmd)){
			DaoUsuario d = new DaoUsuario();
			Usuario usu = new Usuario();
			usu.setId(Integer.parseInt(req.getParameter("id")));
			usu = d.selecionar(usu.getId());
			PrintWriter out = res.getWriter();
			out.println(usu.getNome());
		}
		
		if("Deletar".equals(cmd)){
			DaoUsuario d = new DaoUsuario();
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
			DaoUsuario d = new DaoUsuario();
			Usuario u = new Usuario();
			u.setBio(req.getParameter("bio"));
			u.setId(Integer.parseInt(req.getParameter("id")));
			u.setLogin(req.getParameter("login"));
			u.setNome(req.getParameter("nome"));
			u.setSenha(req.getParameter("senha"));
			boolean ver = d.alterar(u);
			if(ver){
				PrintWriter out = res.getWriter();
				out.println("Sucesso");
			}else{
				PrintWriter out = res.getWriter();
				out.println("Fracasso");
			}
		}
	}

}
