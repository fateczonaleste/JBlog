package br.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.jblog.model.Usuario;

public class DaoUsuarioImpl implements DaoUsuario {

	@Override
	public int update(Usuario u) throws DAOException {

		String sql = "BEGIN PROC_USUARIO_UPDATE(?,?,?,?,?); END;";

		try {
			PreparedStatement stm = ConnectionFactory.getConnection()
					.prepareStatement(sql);

			stm.setDouble(0, u.getId());
			stm.setString(1, u.getNome());
			stm.setString(2, u.getLogin());
			stm.setString(3, u.getSenha());
			stm.setString(4, u.getBio());

			return stm.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Erro ao atualizar Usuario.\n"
					+ e.getMessage());
		}

	}

	@Override
	public int delete(Usuario u) throws DAOException {

		String sql = "BEGIN PROC_USUARIO_DELETE (?); END;";

		try {
			PreparedStatement stm = ConnectionFactory.getConnection()
					.prepareStatement(sql);
			stm.setDouble(0, u.getId());
			return stm.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Erro ao remover Usuario.\n"
					+ e.getMessage());
		}
	}

	@Override
	public int add(Usuario u) throws DAOException {

		String sql = "BEGIN PROC_USUARIO_INSERT (?,?,?,?); END;";

		try {
			PreparedStatement stm = ConnectionFactory.getConnection()
					.prepareStatement(sql);
			stm.setString(0, u.getNome());
			stm.setString(1, u.getLogin());
			stm.setString(2, u.getSenha());
			stm.setString(3, u.getBio());
			return stm.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Erro ao incluir Usuario.\n"
					+ e.getMessage());
		}
	}

	@Override
	public Usuario getById(double id) throws DAOException {

		String sql = "SELECT id_usuario, nome_usuario, login_usuario, senha_usuario, bio_usuario FROM usuario"
				+ " WHERE id_usuario = ? ";
		Usuario usu = new Usuario();
		try {
			PreparedStatement stm = ConnectionFactory.getConnection()
					.prepareStatement(sql);
			stm.setDouble(1, id);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				usu.setBio(rs.getString("bio_usuario"));
				usu.setId(rs.getDouble("id_usuario"));
				usu.setLogin(rs.getString("login_usuario"));
				usu.setNome(rs.getString("nome_usuario"));
				usu.setSenha(rs.getString("senha_usuario"));
			}
			return usu;
		} catch (SQLException e) {
			throw new DAOException("Erro ao obter Usuario por Id.\n"
					+ e.getMessage());
		}
	}

	@Override
	public List<Usuario> listAll() throws DAOException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT id_usuario, bio_usuario, login_usuario, nome_usuario, senha_usuario"
				+ " FROM usuario ORDER BY nome_usuario ";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			List<Usuario> lista = new ArrayList<Usuario>();

			while (rs.next()) {
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
			throw new DAOException("Erro ao listar todos os Usuarios.\n"
					+ e.getMessage());
		}
	}

}
