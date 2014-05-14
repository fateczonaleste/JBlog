package br.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.jblog.model.Blog;

public class DaoBlog{
	
	
	public boolean alterar(Blog b) {		
		Connection con = Conexao.getConnection();
		String sql = "UPDATE blog SET titulo_blog = ? , descricao_blog = ? , meta = ? where id_blog = ?";
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, b.getTitulo());
			stm.setString(2, b.getDescricao());
			stm.setString(3, b.getMeta());
			stm.setDouble(4, b.getId());
			stm.execute();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean deletar(Double codigo) {
		Connection con = Conexao.getConnection();
		String sql = "DELETE FROM blog 	WHERE id_blog = ? ";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setDouble(1, codigo);
			stm.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean inserir(Blog b) {
		Connection con = Conexao.getConnection();
		String sql = "INSERT INTO blog (id_blog, titulo_blog, descricao_blog, meta) VALUES ( ?, ? , ? , ? )";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setDouble(1, b.getId());
			stm.setString(2, b.getTitulo());
			stm.setString(3, b.getDescricao());
			stm.setString(4, b.getMeta());
			stm.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public Blog selecionar(Double codigo) {
		Connection con = Conexao.getConnection();
		String sql = "SELECT id_blog, titulo_blog, descricao_blog, meta FROM blog WHERE id_blog = ? ";
		Blog blog = new Blog();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setDouble(1, codigo);
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
				blog.setDescricao(rs.getString("descricao_blog"));
				blog.setId(rs.getDouble("id_blog"));
				blog.setMeta(rs.getString("meta"));
				blog.setTitulo(rs.getString("titulo_blog"));
			}	
			return blog;
		}catch(SQLException e){
			return blog;
		}
	}
	
	public List<Blog> selecionarBlogs()  {
		Connection con = Conexao.getConnection();
		String sql = "SELECT id_blog, titulo_blog, descricao_blog, meta FROM blog ORDER BY titulo ";
		
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
