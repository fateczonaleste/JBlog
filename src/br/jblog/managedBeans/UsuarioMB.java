package br.jblog.managedBeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.jblog.dao.DaoUsuario;
import br.jblog.dao.DaoUsuarioImpl;
import br.jblog.model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioMB {
	private Usuario usuario;
	private List<Usuario> usuarios;
	
	
	public UsuarioMB() {
		usuario = new Usuario();
		usuarios = new ArrayList<Usuario>();
	}
	
	public Usuario getUsuario(){
		return usuario;
	}

	public List<Usuario> getUsuarios(){
		return usuarios;
	}
	
	public String adicionar(){
		DaoUsuario dao = new DaoUsuarioImpl();
		dao.add(usuario);
		return "";
	}
	
	public String deletar (){
		DaoUsuario dao = new DaoUsuarioImpl();
		dao.delete(usuario);
		return ""; 
	}
	
	public String alterar(){
		DaoUsuario dao = new DaoUsuarioImpl();
		dao.update(usuario);
		return "";
	}
	
	public String selecionar(){
		DaoUsuario dao = new DaoUsuarioImpl();
		usuario = dao.getById(usuario.getId());
		return "";
	}
	
	public String consultarTodos(){
		DaoUsuario cDao = new DaoUsuarioImpl();
		usuarios = cDao.listAll();
		return "";
	}
}
