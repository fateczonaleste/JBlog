package br.jblog.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.jblog.model.Comentario;

public class DaoComentario  {


	public boolean inserir() {
		Connection con = ConnectionFactory.getConnection();
		String sql = "INSERT INTO comentario (id_comentario, datacriacao_comentario, conteudo_comentario, id_post, id_usuario)"
				+" VALUES ( 1, 'data' , 'conteudo', 1, 1)";
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
		Connection con = ConnectionFactory.getConnection();
		String sql = "UPDATE comentario SET datacriacao_comentario = 'data', conteudo_comentario = 'conteudo',"
				+" where id_comentario = 1";
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
		Connection con = ConnectionFactory.getConnection();
		String sql = "DELETE FROM comentario WHERE id_comentario = '123'";
		try {
			Statement stm = con.createStatement();
			stm.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	public Comentario selecionar() {

		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT id_comentario, datacriacao_comentario, conteudo_comentario, id_post, id_usuario"
					+" FROM comentario WHERE id_comentario = '1' ";
		Comentario comentario = new Comentario();
		try{
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			comentario.setConteudo(rs.getString("conteudo_comentario"));
			comentario.setId(rs.getDouble("id_comentario"));
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			comentario.setDataCriacao(sdf.parse(rs.getString("datacriacao_comentario")));
			//comentario.setEmail(rs.getString("email"));
			//comentario.setNome(rs.getString(""));
			return comentario ;
		}catch(SQLException e){
			return comentario ;
		} catch (ParseException e) {	
			e.printStackTrace();
			return comentario ;
		}
	}

}
