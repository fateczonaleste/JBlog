package com.github.easelias.jblog.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuario");
		factory = Persistence.createEntityManagerFactory("blog");
		factory = Persistence.createEntityManagerFactory("post");
		factory = Persistence.createEntityManagerFactory("comentario");	
		factory.close();
	}
	
}
