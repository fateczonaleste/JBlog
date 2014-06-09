package com.github.easelias.jblog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.github.easelias.jblog.model.Usuario;

public class DAOUsuarioImpl implements DAOUsuario {

	@Override
	public Long update(Usuario u) throws DAOException {

		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("usuario");
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
	public Long delete(Usuario u) throws DAOException {

		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("usuario");
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
	public Long add(Usuario u) throws DAOException {

		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("usuario");
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
	public Usuario getById(double id) throws DAOException {

		try {
			Usuario usuario;
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("usuario");
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
					.createEntityManagerFactory("usuario");
			EntityManager manager = factory.createEntityManager();

			Query query = manager
					.createQuery("select u from Usuario where u.nome LIKE :nome");
			query.setParameter("nome", "%"+nome+"%");
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
					.createEntityManagerFactory("usuario");
			EntityManager manager = factory.createEntityManager();

			List<Usuario> lista = manager.createQuery(
					"select u from Usuario order by u.nome").getResultList();

			manager.close();
			factory.close();

			return lista;
		} catch (Exception e) {
			throw new DAOException("Erro ao listar todos os Usuarios.\n"
					+ e.getMessage());
		}
	}
}
