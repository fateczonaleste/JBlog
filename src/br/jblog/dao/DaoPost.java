package br.jblog.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import br.jblog.model.Post;

public class DaoPost {
	
	public boolean inserir() {
		Connection con = Conexao.getConnection();
		String sql = "INSERT INTO comentario (id_post, titulo_post, datacriacao_post, conteudo_post, idCategoria, id_usuario, id_usuario)"
				+" VALUES ( 1, 'titulo', 'data' , 'conteudo', 1, 1  , 1)";
		try {
			Statement stm = con.createStatement();
			stm.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean alterar() {	
		Connection con = Conexao.getConnection();
		String sql = "UPDATE comentario SET titulo_post = 'titulo', datacriacao_post = 'date', conteudo_post = 'conteudo', idCategoria = 1 "
				+" where id_post = 1";
		try{
			Statement stm = con.createStatement();
			stm.execute(sql);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}


	public boolean delete() {
		Connection con = Conexao.getConnection();
		String sql = "DELETE FROM post WHERE id_post = '123'";
		try {
			Statement stm = con.createStatement();
			stm.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	public Post selecionar() {
		Connection con = Conexao.getConnection();
		String sql = "SELECT id_post, titulo_post, datacriacao_post, conteudo_post, idCategoria, id_usuario, id_usuario"
					+" FROM post WHERE id_post = '1' ";
		Post p = new Post();
		try{
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			p.setConteudo(rs.getString("conteudo_post"));
			p.setId(rs.getDouble("id_post"));
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			p.setDataCriacao(sdf.parse(rs.getString("datacriacao_post")));
			p.setTitulo(rs.getString("titulo_post"));
			return p ;
		}catch(SQLException e){
			return p ;
		} catch (ParseException e) {	
			e.printStackTrace();
			return p ;
		}
	}
	
	public List<Post> selecionarPosts()  {
		Connection con = Conexao.getConnection();
		String sql = "SELECT id_post, titulo_post, datacriacao_post, conteudo_post, idCategoria, id_usuario, id_usuario "+
		" FROM Post ORDER BY datacriacao_post ";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			List<Post> lista = new ArrayList<Post>();
			while(rs.next()){
				Post p = new Post();
				p.setConteudo(rs.getString("conteudo_post"));
				p.setId(rs.getDouble("id_post"));
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				p.setDataCriacao(sdf.parse(rs.getString("datacriacao_post")));
				p.setTitulo(rs.getString("titulo_post"));
				lista.add(p);
			}
			return lista;
		} catch (SQLException e) {
			List<Post> lista = new ArrayList<Post>();
			return lista;
		} catch (ParseException e) {
			List<Post> lista = new ArrayList<Post>();
			return lista;
		}
	}

}
