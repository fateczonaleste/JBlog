package com.github.easelias.jblog.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.easelias.jblog.model.Post;
import com.github.easelias.jblog.model.Usuario;

public class DaoPostImpl implements DaoPost {

	@Override
	public int add(Post p, double id_usuario) {
		Connection con = ConnectionFactory.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String sql = "INSERT INTO post (id_post, titulo_post, datacriacao_post, conteudo_post, id_usuario ) "
				+ " VALUES ( sqpost.nextval , ? , '"	+ sdf.format(new Date()) + "', ? , ?  ) ";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			//stm.setDouble(1, p.getId());
			stm.setString(1, p.getTitulo());
			//Usuario u = p.getUsuario();
			//u.setId(1);
			stm.setString(2, p.getConteudo());
			stm.setDouble(3, id_usuario);
			stm.execute();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean update(Post p) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "UPDATE post SET titulo_post = ?, conteudo_post = ? "
				+ " where id_post = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, p.getTitulo());
			stm.setString(2, p.getConteudo());
			stm.setDouble(3, p.getId());
			stm.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Post p) {
		
		
		Connection con = ConnectionFactory.getConnection();
		
		CallableStatement cs = null;
		String sql = "{call deletePOST(?)}";
		try {
			cs = con.prepareCall(sql);
			cs.setDouble(1, p.getId());
			cs.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Post getById(double id) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT id_post, titulo_post, datacriacao_post, conteudo_post, id_usuario "
				+ " FROM post WHERE id_post = ? ";
		Post p = new Post();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setDouble(1, id);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				p.setId(rs.getDouble("id_post"));
				p.setTitulo(rs.getString("titulo_post"));
				p.setDataCriacao(rs.getDate("datacriacao_post"));
				p.setConteudo(rs.getString("conteudo_post"));
				Usuario u = new Usuario();
				u.setId(rs.getLong("id_usuario"));
				p.setAutor(u);
			}
			return p;
		} catch (SQLException e) {
			return p;
		}
	}

	@Override
	public List<Post> listAll() {
		Connection con = ConnectionFactory.getConnection();
		String sql = " SELECT id_post, titulo_post, datacriacao_post, conteudo_post, id_usuario "
				+ " FROM Post ORDER BY datacriacao_post ";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			List<Post> lista = new ArrayList<Post>();
			while (rs.next()) {
				Post p = new Post();
				p.setConteudo(rs.getString("conteudo_post"));
				p.setId(rs.getDouble("id_post"));
				p.setDataCriacao(rs.getDate("datacriacao_post"));
				p.setTitulo(rs.getString("titulo_post"));
				lista.add(p);
			}
			return lista;
		} catch (SQLException e) {
			List<Post> lista = new ArrayList<Post>();
			Post p = new Post();
			p.setTitulo("N�o h� posts");
			lista.add(p);
			return lista;
		}
	}

}
