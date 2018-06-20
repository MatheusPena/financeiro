package br.com.grupoferraz.financeiro.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtilAux {
	
	public JPAUtilAux() {
		
	}
	
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("sgi");
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
}
