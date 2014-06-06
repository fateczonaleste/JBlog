package br.jblog.managedBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.jblog.dao.DAOException;
import br.jblog.dao.DaoUsuario;
import br.jblog.dao.DaoUsuarioImpl;
import br.jblog.model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioMB {
	private Usuario usuario;
	private List<Usuario> usuarios;

	private void mostrarMensagem(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(mensagem));
	}

	@SuppressWarnings("unchecked")
	public UsuarioMB() throws IOException {
		usuario = new Usuario();
		usuarios = (List<Usuario>) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("USUARIOS");
		if (usuarios == null) {
			usuarios = new ArrayList<Usuario>();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public String adicionar() {
		String mensagem;
		try {
			DaoUsuario dao = new DaoUsuarioImpl();
			dao.add(usuario);
			mensagem = "Adicionado com sucesso.";
		} catch (DAOException e) {
			mensagem = e.getMessage();
		}
		mostrarMensagem(mensagem);
		return "";
	}

	public String deletar() {
		String mensagem;
		try {
			DaoUsuario dao = new DaoUsuarioImpl();
			dao.delete(usuario);
			mensagem = "Removido com sucesso.";
		} catch (DAOException e) {
			mensagem = e.getMessage();
		}
		mostrarMensagem(mensagem);
		return "";
	}

	public String alterar() {
		String mensagem;
		try {
			DaoUsuario dao = new DaoUsuarioImpl();
			dao.update(usuario);
			mensagem = "Salvo com sucesso.";
		} catch (DAOException e) {
			mensagem = e.getMessage();
		}
		mostrarMensagem(mensagem);
		return "";
	}

	public String selecionar() {
		String mensagem;
		try {
			DaoUsuario dao = new DaoUsuarioImpl();
			usuario = dao.getById(usuario.getId());
			mensagem = "Consulta realizada.";
		} catch (DAOException e) {
			mensagem = e.getMessage();
		}
		mostrarMensagem(mensagem);
		return "";
	}

	public String consultarTodos() {

		String mensagem;
		try {
			DaoUsuario cDao = new DaoUsuarioImpl();
			usuarios = cDao.listAll();
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("USUARIOS", usuarios);
			System.out.println("1");
			// mensagem = usuarios.size() + "Usuário(s) encontrado(s)";

		} catch (DAOException e) {
			mensagem = e.getMessage();
		}
		// mostrarMensagem(mensagem);
		return "";
	}
}
