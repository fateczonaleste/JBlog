package br.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.jblog.model.Usuario;

public class DaoUsuario {
	public boolean alterar(Usuario u) {	
		Connection con = Conexao.getConnection();
		String sql = "UPDATE usuario SET nome_usuario = ? , login_usuario = ? , senha_usuario = ? , bio_usuario = ? "+
					"where id_usuario = ? ";
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, u.getNome());
			stm.setString(2, u.getLogin());
			stm.setString(3, u.getSenha());
			stm.setString(4, u.getBio());
			stm.setDouble(5, u.getId());
			stm.execute();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public boolean deletar(Double codigo) {
		Connection con = Conexao.getConnection();
		String sql = "DELETE FROM usuario 	WHERE id_usuario = ? ";
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
	
	
	public boolean inserir(Usuario u) {
		Connection con = Conexao.getConnection();
		String sql = " INSERT INTO usuario (id_usuario, nome_usuario, login_usuario, senha_usuario, bio_usuario) "+
				" VALUES ( ? , ? , ? , ? , ? ) ";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setDouble(1, u.getId());
			stm.setString(2, u.getNome());
			stm.setString(3, u.getLogin());
			stm.setString(4, u.getSenha());
			stm.setString(5, u.getBio());
			stm.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public Usuario selecionar(Double codigo) {
		Connection con = Conexao.getConnection();
		String sql = "SELECT id_usuario, nome_usuario, login_usuario, senha_usuario, bio_usuario FROM usuario"+
					" WHERE id_usuario = ? ";
		Usuario usu = new Usuario();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setDouble(1, codigo );
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
				usu.setBio(rs.getString("bio_usuario"));
				usu.setId(rs.getDouble("id_usuario"));
				usu.setLogin(rs.getString("login_usuario"));
				usu.setNome(rs.getString("nome_usuario"));
				usu.setSenha(rs.getString("senha_usuario"));
			}
			return usu;
		}catch(SQLException e){
			System.out.print(e.toString());
			return usu;
		}
	}
	
	public List<Usuario> selecionarBlogs()  {
		Connection con = Conexao.getConnection();
		String sql = "SELECT id_usuario, bio_usuario, login_usuario, nome_usuario, senha_usuario"+
					" FROM usuario ORDER BY nome_usuario ";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			List<Usuario> lista = new ArrayList<Usuario>();
			
			while(rs.next()){
				Usuario usu = new Usuario();
				usu.setBio(rs.getString("bio_usuario"));
				usu.setId(rs.getDouble("id_usuario"));
				usu.setLogin(rs.getString("login_usuario"));
				usu.setNome(rs.getString("nome_usuario"));
				usu.setSenha(rs.getString("senha_usuario"));
				lista.add(usu);
			}
			return lista;
		} catch (SQLException e) {
			List<Usuario> lista = new ArrayList<Usuario>();
			return lista;
		}
	}

}
