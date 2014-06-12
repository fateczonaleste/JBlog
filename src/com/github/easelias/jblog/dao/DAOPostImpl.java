package com.github.easelias.jblog.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.github.easelias.jblog.model.Post;

public class DAOPostImpl implements DAOPost {

	private final String _TABELA = "post";

	@Override
	public long add(Post p) throws DAOException {
		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			manager.getTransaction().begin();
			manager.persist(p);
			manager.getTransaction().commit();

			manager.close();
			factory.close();

			return p.getId();

		} catch (Exception e) {
			throw new DAOException("Erro ao incluir Post.\n" + e.getMessage());
		}
	}

	@Override
	public long update(Post p) throws DAOException {
		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			manager.getTransaction().begin();
			manager.merge(p);
			manager.getTransaction().commit();

			manager.close();
			factory.close();

			return p.getId();

		} catch (Exception e) {
			throw new DAOException("Erro ao atualizar Post.\n" + e.getMessage());
		}

	}

	@Override
	public long delete(Post p) throws DAOException {
		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			manager.getTransaction().begin();
			manager.remove(p);
			manager.getTransaction().commit();

			manager.close();
			factory.close();

			return p.getId();

		} catch (Exception e) {
			throw new DAOException("Erro ao remover Post.\n" + e.getMessage());
		}
	}

	@Override
	public Post getById(long id) throws DAOException {
		try {
			Post post;
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			post = manager.find(Post.class, id);

			manager.close();
			factory.close();

			return post;

		} catch (Exception e) {
			throw new DAOException("Erro ao obter Post por Id.\n"
					+ e.getMessage());
		}
	}

	@Override
	public List<Post> listAll() throws DAOException {

		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			List<Post> lista = manager.createQuery(
					"SELECT p FROM Post ORDER BY p.dataCriacao", Post.class)
					.getResultList();

			manager.close();
			factory.close();

			return lista;
		} catch (Exception e) {
			throw new DAOException("Erro ao listar todos os Posts.\n"
					+ e.getMessage());
		}
	}

	@Override
	public List<Post> searchByTitulo(String titulo) throws DAOException {
		try {
			List<Post> lista = new ArrayList<Post>();
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			TypedQuery<Post> query = manager.createQuery(
					"SELECT p FROM Post WHERE p.titulo LIKE :titulo",
					Post.class);
			query.setParameter("titulo", "%" + titulo + "%");
			lista = query.getResultList();

			manager.close();
			factory.close();

			return lista;
		} catch (Exception e) {
			throw new DAOException("Erro ao pesquisar Post por Título.\n"
					+ e.getMessage());
		}
	}

	@Override
	public List<Post> searchByDataCriacao(Date dataCriacao) throws DAOException {
		try {
			List<Post> lista = new ArrayList<Post>();
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory(_TABELA);
			EntityManager manager = factory.createEntityManager();

			TypedQuery<Post> query = manager.createQuery(
					"SELECT p FROM Post WHERE p.dataCriacao=:dataCriacao",
					Post.class);
			query.setParameter("dataCriacao", dataCriacao);
			lista = query.getResultList();

			manager.close();
			factory.close();

			return lista;
		} catch (Exception e) {
			throw new DAOException(
					"Erro ao pesquisar Post por Data de Criação.\n"
							+ e.getMessage());
		}
	}

}
