package com.github.easelias.jblog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.github.easelias.jblog.model.Usuario;

public class DAOUsuarioImpl implements DAOUsuario {

	private final String _TABELA = "usuario";

	@Override
	public long update(Usuario u) throws DAOException {

		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			manager.getTransaction().begin();
			manager.merge(u);
			manager.getTransaction().commit();

			manager.close();
			factory.close();

			return u.getId();

		} catch (Exception e) {
			throw new DAOException("Erro ao atualizar Usuario.\n"
					+ e.getMessage());
		}

	}

	@Override
	public long delete(Usuario u) throws DAOException {

		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			manager.getTransaction().begin();
			manager.remove(u);
			manager.getTransaction().commit();

			manager.close();
			factory.close();

			return u.getId();

		} catch (Exception e) {
			throw new DAOException("Erro ao remover Usuario.\n"
					+ e.getMessage());
		}
	}

	@Override
	public long add(Usuario u) throws DAOException {

		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			manager.getTransaction().begin();
			manager.persist(u);
			manager.getTransaction().commit();

			manager.close();
			factory.close();

			return u.getId();

		} catch (Exception e) {
			throw new DAOException("Erro ao incluir Usuario.\n"
					+ e.getMessage());
		}
	}

	@Override
	public Usuario getById(long id) throws DAOException {

		try {
			Usuario usuario;
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			usuario = manager.find(Usuario.class, id);

			manager.close();
			factory.close();

			return usuario;

		} catch (Exception e) {
			throw new DAOException("Erro ao obter Usuario por Id.\n"
					+ e.getMessage());
		}
	}

	@Override
	public List<Usuario> searchByNome(String nome) throws DAOException {

		try {
			List<Usuario> lista = new ArrayList<Usuario>();
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			TypedQuery<Usuario> query = manager.createQuery(
					"SELECT u FROM Usuario WHERE u.nome LIKE :nome",
					Usuario.class);
			query.setParameter("nome", "%" + nome + "%");
			lista = query.getResultList();

			manager.close();
			factory.close();

			return lista;
		} catch (Exception e) {
			throw new DAOException("Erro ao pesquisa Usuario por Nome.\n"
					+ e.getMessage());
		}
	}

	@Override
	public List<Usuario> listAll() throws DAOException {

		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			List<Usuario> lista = manager.createQuery(
					"SELECT u FROM Usuario ORDER BY u.nome", Usuario.class)
					.getResultList();

			manager.close();
			factory.close();

			return lista;
		} catch (Exception e) {
			throw new DAOException("Erro ao listar todos os Usuarios.\n"
					+ e.getMessage());
		}
	}
}
