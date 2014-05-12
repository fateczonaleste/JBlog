package br.jblog.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.jblog.model.Usuario;

public class DaoUsuario {
	public boolean alterar() {	
		Connection con = Conexao.getConnection();
		String sql = "UPDATE usuario SET nome_usuario = 'nome', login_usuario = 'login' , senha_usuario = 'senha', bio_usuario = 'bio' "+
					"where id_usuario = 1";
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
		String sql = "DELETE FROM usuario 	WHERE id_usuario = '111'";
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
		String sql = " INSERT INTO usuario (id_usuario, nome_usuario, login_usuario, senha_usuario, bio_usuario) "+
				" VALUES ( 123, 'nome' , 'login', 'senha', 'bio') ";
		try {
			Statement stm = con.createStatement();
			stm.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public Usuario selecionar() {
		Connection con = Conexao.getConnection();
		String sql = "SELECT id_usuario, nome_usuario, login_usuario, senha_usuario, bio_usuario FROM usuario"+
					" WHERE id_usuario = '1' ";
		Usuario usu = new Usuario();
		try{
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			usu.setBio(rs.getString("bio_usuario"));
			usu.setId(rs.getDouble("id_usuario"));
			usu.setLogin(rs.getString("login_usuario"));
			usu.setNome(rs.getString("nome_usuario"));
			usu.setSenha(rs.getString("senha_usuario"));
			return usu;
		}catch(SQLException e){
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
