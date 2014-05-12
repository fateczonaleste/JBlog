package br.jblog.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.jblog.model.Blog;

public class DaoBlog{
	
	
	public boolean alterar() {		
		Connection con = Conexao.getConnection();
		String sql = "UPDATE blog SET titulo = 'Titulo', descricao = 'descricao' , meta = '#meta' where id = 1";
		try{
			Statement stm = con.createStatement();
			stm.execute(sql);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public boolean deletar() {
		Connection con = Conexao.getConnection();
		String sql = "DELETE FROM blog 	WHERE id = '123'";
		try {
			Statement stm = con.createStatement();
			stm.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean inserir() {
		Connection con = Conexao.getConnection();
		String sql = "INSERT INTO blog (id, titulo, descricao, meta) VALUES ( 123, 'Título' , 'Descricao', '#meta')";
		try {
			Statement stm = con.createStatement();
			stm.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public Blog selecionar() {
		Connection con = Conexao.getConnection();
		String sql = "SELECT id, titulo, descricao, meta FROM blog WHERE id = '1' ";
		Blog blog = new Blog();
		try{
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			blog.setDescricao(rs.getString("descricao"));
			blog.setId(rs.getDouble("id"));
			blog.setMeta(rs.getString("meta"));
			blog.setTitulo(rs.getString("titulo"));
			return blog;
		}catch(SQLException e){
			return blog;
		}
	}
	
	public List<Blog> selecionarBlogs()  {
		Connection con = Conexao.getConnection();
		String sql = "SELECT id, titulo, descricao, meta FROM blog ORDER BY titulo ";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			List<Blog> lista = new ArrayList<Blog>();
			
			while(rs.next()){
				Blog b = new Blog();
				b.setDescricao(rs.getString("descricao"));
				b.setId(rs.getDouble("id"));
				b.setMeta(rs.getString("meta"));
				b.setTitulo(rs.getString("titulo"));
				lista.add(b);
			}
			return lista;
		} catch (SQLException e) {
			List<Blog> lista = new ArrayList<Blog>();
			return lista;
		}
	}
}
