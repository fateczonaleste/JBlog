package br.jblog.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import br.jblog.model.Categoria;

public class DaoCategoria {
	public boolean alterar(){
		Connection con = Conexao.getConnection();
		String sql = "UPDATE categoria SET nome = 'nome', descricao = 'descricao' ";
		
		try {
			Statement stm = con.createStatement();
			stm.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
	}
	
	public boolean deletar(){
		Connection con = Conexao.getConnection();
		String sql = "DELETE FROM categoria WHERE id = '123'";
		try {
			Statement stm = con.createStatement();
			stm.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean inserir(){
		Connection con = Conexao.getConnection();
		String sql = "";
		try {
			Statement stm = con.createStatement();
			stm.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Categoria selecionar(){
		Connection con = Conexao.getConnection();
		String sql = "SELECT id, titulo, descricao, meta FROM blog WHERE id = '1' ";
		Categoria categoria = new Categoria();
		try{
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			categoria.setDescricao(rs.getString("descricao"));
			categoria.setId(rs.getDouble("id"));
			categoria.setNome(rs.getString("nome"));
			return categoria;
		}catch(SQLException e){
			return categoria;
		}
	}
	
	public List<Categoria> selecionarCategorias(){
		Connection con = Conexao.getConnection();
		String sql = "";
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				Categoria categoria = new Categoria();
				categoria.setDescricao(rs.getString("descricao"));
				categoria.setId(rs.getDouble("id"));
				categoria.setNome(rs.getString("nome"));
				lista.add(categoria);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return lista;
		}
		
	}
}
