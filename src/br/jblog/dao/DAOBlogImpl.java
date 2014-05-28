package br.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.jblog.model.Blog;

// Fonte: http://www.oracle.com/technetwork/java/dataaccessobject-138824.html
// Oacle Procedures in Java: http://docs.oracle.com/cd/B25329_01/doc/appdev.102/b25108/xedev_jdbc.htm
public class DAOBlogImpl implements DaoBlog {

	@Override
	public int add(Blog b) throws DAOException {
		Connection con = ConnectionFactory.getConnection();
		final String sql = "BEGIN PROC_BLOG_INSERT (?,?); END;";
		try {
			PreparedStatement stm = con.prepareStatement(sql);

			stm.setString(1, b.getTitulo());
			stm.setString(2, b.getDescricao());

			return stm.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Exceção ao adicionar Blog.\n"
					+ e.getMessage());
		}
	}

	@Override
	public int update(Blog b) throws DAOException {
		String sql = "BEGIN PROC_BLOG_UPDATE (?,?,?); END;";
		try {
			PreparedStatement stm = ConnectionFactory.getConnection()
					.prepareStatement(sql);
			stm.setDouble(1, b.getId());
			stm.setString(2, b.getTitulo());
			stm.setString(3, b.getDescricao());

			return stm.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Exceção ao atualizar Blog.\n"
					+ e.getMessage());
		}

	}

	@Override
	public List<Blog> listAll() throws DAOException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT id_blog, titulo_blog, descricao_blog FROM blog ";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			List<Blog> lista = new ArrayList<Blog>();

			while (rs.next()) {
				Blog b = new Blog();
				b.setDescricao(rs.getString("descricao_blog"));
				b.setId(rs.getDouble("id_blog"));
				b.setTitulo(rs.getString("titulo_blog"));
				lista.add(b);
			}
			return lista;
		} catch (SQLException e) {
			throw new DAOException("Exceção ao listar Blogs.\n"
					+ e.getMessage());
		}
	}

	@Override
	public Blog getById(double id) throws DAOException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT id_blog, titulo_blog, descricao_blog FROM blog WHERE id_blog = ? ";
		Blog blog = null;
		try {
			blog = new Blog();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setDouble(1, id);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				blog.setDescricao(rs.getString("descricao_blog"));
				blog.setId(rs.getDouble("id_blog"));
				blog.setTitulo(rs.getString("titulo_blog"));
			}
			return blog;
		} catch (SQLException e) {
			throw new DAOException("Exceção ao selecionar Blog.\n"
					+ e.getMessage());
		}
	}

	@Override
	public int delete(Blog b) throws DAOException {

		String sql = "BEGIN PROC_BLOG_DELETE (?); END;";
		try {
			PreparedStatement stm = ConnectionFactory.getConnection()
					.prepareStatement(sql);
			stm.setDouble(1, b.getId());
			return stm.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Exceção ao remover Blog.\n"
					+ e.getMessage());
		}
	}

}
