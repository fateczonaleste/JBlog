package br.jblog.managedBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;

import br.jblog.dao.DAOException;
import br.jblog.dao.DaoUsuario;
import br.jblog.dao.DaoUsuarioImpl;
import br.jblog.model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioMB {
	private Usuario usuario;
	private List<Usuario> usuarios;
	private Usuario usuarioSelecionado;

	private void mostrarMensagem(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(mensagem));
	}

	@SuppressWarnings("unchecked")
	public UsuarioMB() throws IOException {
		usuario = new Usuario();
		usuarios = new ArrayList<Usuario>();
		usuarioSelecionado = new Usuario();

		usuarios = (List<Usuario>) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("USUARIOS");
		
		consultarTodos();
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario u){
		usuario = u;
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

	public void deletar() {
		String mensagem;
		try {
			DaoUsuario dao = new DaoUsuarioImpl();
			dao.delete(usuario);
			mensagem = "Removido com sucesso.";
		} catch (DAOException e) {
			mensagem = e.getMessage();
		}
		mostrarMensagem(mensagem);		
	}

	public void alterar() {
		String mensagem;
		try {
			DaoUsuario dao = new DaoUsuarioImpl();
			dao.update(usuario);
			mensagem = "Salvo com sucesso.";
		} catch (DAOException e) {
			mensagem = e.getMessage();
		}
		mostrarMensagem(mensagem);		
	}

	public void selecionar() {
		String mensagem;
		try {
			DaoUsuario dao = new DaoUsuarioImpl();
			usuarios = dao.searchByNome(usuario.getNome());
			mensagem = "Consulta realizada.";
		} catch (DAOException e) {
			mensagem = e.getMessage();
		}
		mostrarMensagem(mensagem);
	}

	public void consultarTodos() {

		String mensagem;
		try {
			DaoUsuario cDao = new DaoUsuarioImpl();
			usuarios = cDao.listAll();
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("USUARIOS", usuarios);
			mensagem = usuarios.size() + " Usuario(s) encontrado(s)";

		} catch (DAOException e) {
			mensagem = e.getMessage();
		}
		mostrarMensagem(mensagem);
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;

	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado)
			throws IOException, ServletException {
		this.usuarioSelecionado = usuarioSelecionado;
		usuario = usuarioSelecionado;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put("USUARIO", usuarioSelecionado);
	}

}
