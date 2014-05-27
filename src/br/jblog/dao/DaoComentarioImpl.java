package br.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.jblog.model.Comentario;
import br.jblog.model.Post;

public class DaoComentarioImpl implements DaoComentario {

	@Override
	public int add(Comentario c, double idPost) {
		Connection con = ConnectionFactory.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String sql = "INSERT INTO comentario (id_comentario, datacriacao_comentario, conteudo_comentario, nome_comentario, id_post, email_comentario)"
				+ " VALUES (sqcomentario.nextval, '"
				+ sdf.format(new Date())
				+ "' , ? , ? , ? , ? ) ";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, c.getConteudo());
			stm.setString(2, c.getNome());
			stm.setDouble(3, idPost);
			stm.setString(4, c.getEmail());
			stm.execute();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean update(Comentario c) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "UPDATE comentario SET datacriacao_comentario = ?, conteudo_comentario = ?, nome_comentario = ? "
				+ " where id_comentario = ? ";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setDate(1, (java.sql.Date) c.getDataCriacao());
			stm.setString(2, c.getConteudo());
			stm.setString(3, c.getNome());
			stm.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Comentario c) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "DELETE FROM comentario WHERE id_comentario = ? ";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setDouble(1, c.getId());
			stm.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Comentario getById(double idComentario) {

		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT id_comentario, datacriacao_comentario, conteudo_comentario, id_post, nome_comentario "
				+ " FROM comentario WHERE id_comentario = ? ";
		Comentario comentario = new Comentario();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setDouble(1, idComentario);
			ResultSet rs = stm.executeQuery();
			comentario.setConteudo(rs.getString("conteudo_comentario"));
			comentario.setId(rs.getDouble("id_comentario"));
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			comentario.setDataCriacao(sdf.parse(rs
					.getString("datacriacao_comentario")));
			comentario.setNome(rs.getString("nome_comentario"));
			return comentario;
		} catch (SQLException e) {
			return comentario;
		} catch (ParseException e) {
			e.printStackTrace();
			return comentario;
		}
	}

	@Override
	public List<Comentario> listAll() {
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT id_comentario, datacriacao_comentario, conteudo_comentario,  nome_comentario, email_comentario "
				+ " FROM comentario ORDER BY datacriacao_comentario ";
		
		List<Comentario> lista = new ArrayList<Comentario>();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Comentario comentario = new Comentario();
				comentario.setConteudo(rs.getString("conteudo_comentario"));
				comentario.setId(rs.getDouble("id_comentario"));
				comentario.setDataCriacao(rs.getDate("datacriacao_comentario"));
				comentario.setNome(rs.getString("nome_comentario"));
				comentario.setEmail(rs.getString("email_comentario"));
			    lista.add(comentario);
			    System.out.println("p1");
			}
			return lista;
		} catch (SQLException e) {
			System.out.println("p2");
			return lista;
		} 

	}

	@Override
	public List<Comentario> listByPost(Post p) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT id_comentario, datacriacao_comentario, conteudo_comentario,  nome_comentario, email_comentario "
				+ " FROM comentario WHERE id_post = ? ORDER BY datacriacao_comentario ";
		
		List<Comentario> lista = new ArrayList<Comentario>();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setDouble(1, p.getId());
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Comentario comentario = new Comentario();
				comentario.setConteudo(rs.getString("conteudo_comentario"));
				comentario.setId(rs.getDouble("id_comentario"));
				comentario.setDataCriacao(rs.getDate("datacriacao_comentario"));
				comentario.setNome(rs.getString("nome_comentario"));
				comentario.setEmail(rs.getString("email_comentario"));
			    lista.add(comentario);
			    System.out.println("p1");
			}
			return lista;
		} catch (SQLException e) {
			System.out.println("p2");
			return lista;
		} 
	}

}
