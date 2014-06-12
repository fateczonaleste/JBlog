package com.github.easelias.jblog.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.github.easelias.jblog.dao.DAOComentario;
import com.github.easelias.jblog.dao.DAOComentarioImpl;
import com.github.easelias.jblog.dao.DAOException;
import com.github.easelias.jblog.model.Comentario;

@ManagedBean
@ViewScoped
public class ComentarioMB {
	private Comentario comentario;
	private List<Comentario> comentarios;

	public ComentarioMB() {
		comentario = new Comentario();
		comentarios = new ArrayList<Comentario>();
	}

	public Comentario getComentario() {
		return comentario;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	private void mostrarMensagem(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(mensagem));
	}

	public void deletar() {
		try {
			DAOComentario dao = new DAOComentarioImpl();
			dao.delete(comentario);
			mostrarMensagem("Comentário removido com sucesso.");
		} catch (DAOException e) {
			mostrarMensagem(e.getMessage());
		}
	}

	public void alterar() {
		try {
			DAOComentario dao = new DAOComentarioImpl();
			dao.update(comentario);
		} catch (DAOException e) {
			mostrarMensagem(e.getMessage());
		}
	}

	public void selecionar() {
		try {
			DAOComentario dao = new DAOComentarioImpl();
			comentario = dao.getById(comentario.getId());
		} catch (DAOException e) {
			mostrarMensagem(e.getMessage());
		}
	}

	public List<Comentario> consultarTodos() {
		try {
			DAOComentario cDao = new DAOComentarioImpl();
			comentarios = cDao.listAll();
		} catch (DAOException e) {
			mostrarMensagem(e.getMessage());
		}
		return comentarios;
	}
}
