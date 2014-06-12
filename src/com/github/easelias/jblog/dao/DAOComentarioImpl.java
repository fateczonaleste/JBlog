package com.github.easelias.jblog.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.github.easelias.jblog.model.Comentario;
import com.github.easelias.jblog.model.Post;

public class DAOComentarioImpl implements DAOComentario {

	private final String _TABELA = "comentario";

	@Override
	public long add(Comentario c) throws DAOException {
		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			manager.getTransaction().begin();
			manager.persist(c);
			manager.getTransaction().commit();

			manager.close();
			factory.close();

			return c.getId();
		} catch (Exception e) {
			throw new DAOException("Erro ao incluir Comentario.\n"
					+ e.getMessage());
		}
	}

	@Override
	public long update(Comentario c) throws DAOException {
		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			manager.getTransaction().begin();
			manager.merge(c);
			manager.getTransaction().commit();

			manager.close();
			factory.close();

			return c.getId();

		} catch (Exception e) {
			throw new DAOException("Erro ao atualizar Comentario.\n"
					+ e.getMessage());
		}
	}

	@Override
	public long delete(Comentario c) throws DAOException {
		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			manager.getTransaction().begin();
			manager.remove(c);
			manager.getTransaction().commit();

			manager.close();
			factory.close();

			return c.getId();

		} catch (Exception e) {
			throw new DAOException("Erro ao remover Comentario.\n"
					+ e.getMessage());
		}
	}

	@Override
	public List<Comentario> listAll() throws DAOException {
		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			List<Comentario> lista = manager.createQuery(
					"SELECT c FROM Comentario ORDER BY p.dataCriacao",
					Comentario.class).getResultList();

			manager.close();
			factory.close();

			return lista;
		} catch (Exception e) {
			throw new DAOException("Erro ao listar todos os Comentarios.\n"
					+ e.getMessage());
		}
	}

	@Override
	public Comentario getById(long id) throws DAOException {
		try {
			Comentario comentario;
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			comentario = manager.find(Comentario.class, id);

			manager.close();
			factory.close();

			return comentario;

		} catch (Exception e) {
			throw new DAOException("Erro ao obter Comentario por Id.\n"
					+ e.getMessage());
		}
	}

	@Override
	public List<Comentario> listByPost(Post p) throws DAOException {
		try {
			List<Comentario> lista = new ArrayList<Comentario>();
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			TypedQuery<Comentario> query = manager.createQuery(
					"SELECT c FROM Comentario WHERE c.post=:post",
					Comentario.class);
			query.setParameter("post", p);
			lista = query.getResultList();

			manager.close();
			factory.close();

			return lista;
		} catch (Exception e) {
			throw new DAOException("Erro ao pesquisar Comentário por Post.\n"
					+ e.getMessage());
		}
	}

	@Override
	public List<Comentario> searchByDataCriacao(Date dataCriacao)
			throws DAOException {
		try {
			List<Comentario> lista = new ArrayList<Comentario>();
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			TypedQuery<Comentario> query = manager
					.createQuery(
							"SELECT c FROM Comentario WHERE c.dataCriacao=:dataCriacao",
							Comentario.class);
			query.setParameter("dataCriacao", dataCriacao);
			lista = query.getResultList();

			manager.close();
			factory.close();

			return lista;
		} catch (Exception e) {
			throw new DAOException(
					"Erro ao pesquisar Comentário por Data de Criação.\n"
							+ e.getMessage());
		}
	}

}
