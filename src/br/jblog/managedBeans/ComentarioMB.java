package br.jblog.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.jblog.dao.DaoComentario;
import br.jblog.dao.DaoComentarioImpl;
import br.jblog.model.Comentario;

@ManagedBean
@ViewScoped
public class ComentarioMB {
	private Comentario comentario;
	private List<Comentario> comentarios;
	
	
	public ComentarioMB() {
		comentario = new Comentario();
		comentarios = new ArrayList<Comentario>();
	}
	
	public Comentario getComentario(){
		return comentario;
	}

	public List<Comentario> getComentarios(){
		return comentarios;
	}
	
	public String adicionar(){
		DaoComentario dao = new DaoComentarioImpl();
		dao.add(comentario, 1);
		return "";
	}
	
	public String deletar (){
		DaoComentario dao = new DaoComentarioImpl();
		dao.delete(comentario);
		return ""; 
	}
	
	public String alterar(){
		DaoComentario dao = new DaoComentarioImpl();
		dao.update(comentario);
		return "";
	}
	
	public String selecionar(){
		DaoComentario dao = new DaoComentarioImpl();
		comentario = dao.getById(comentario.getId());
		return "";
	}
	
	public List<Comentario> consultarTodos(){
		DaoComentario cDao = new DaoComentarioImpl();
		comentarios = cDao.listAll();
		return comentarios;
	}
}
