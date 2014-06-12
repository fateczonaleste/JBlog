package com.github.easelias.jblog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.github.easelias.jblog.model.Blog;

public class DAOBlogImpl implements DAOBlog {

	@Override
	public void save(Blog b) throws DAOException {
		try {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("blog");
			EntityManager manager = factory.createEntityManager();

			manager.getTransaction().begin();
			manager.merge(b);
			manager.getTransaction().commit();

			manager.close();
			factory.close();
		} catch (Exception e) {
			throw new DAOException("Exception in save Blog to database.\n"
					+ e.getMessage());
		}
	}

	@Override
	public Blog getBlog() throws DAOException {

		try {
			Blog b = new Blog();
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("blog");
			EntityManager manager = factory.createEntityManager();

			List<Blog> blogs = manager.createQuery("select b from Blog", Blog.class).getResultList();

			if (blogs.size() > 0) {
				b = blogs.get(0);
			} else {
				b.setTitulo("Titulo");
				manager.getTransaction().begin();
				manager.persist(b);
				manager.getTransaction().commit();
			}

			return b;
		} catch (Exception e) {
			throw new DAOException("Exception in fetch Blog from database.\n"
					+ e.getMessage());
		}
	}

}
