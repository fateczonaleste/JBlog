package br.jblog.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.jblog.dao.DaoPost;
import br.jblog.dao.DaoPostImpl;
import br.jblog.model.Post;
import br.jblog.model.Usuario;


@ManagedBean
@ViewScoped
public class PostMB {
	private Post post;
	private List<Post> posts;
	
	
	public PostMB() {
		post = new Post();
		posts = new ArrayList<Post>();
	}
	
	public Post getPost(){
		return post;
	}

	public List<Post> getPosts(){
		return posts;
	}
	
	public void adicionar(){
		DaoPost dao = new DaoPostImpl();
		Usuario u = post.getUsuario();
		dao.add(post, u.getId());
	}
	
	public void deletar (){
		DaoPost dao = new DaoPostImpl();
		dao.delete(post);
	}
	
	public void alterar(){
		DaoPost dao = new DaoPostImpl();
		dao.update(post);
	}
	
	public void selecionar(){
		DaoPost dao = new DaoPostImpl();
		post = dao.getById(post.getId());
	}
	
	public List<Post> consultarTodos(){
		DaoPost cDao = new DaoPostImpl();
		posts = cDao.listAll();
		return posts;	
	}
}
