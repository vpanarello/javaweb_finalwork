/**
 * 
 */
package br.com.fiap.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * simple-webapp / JpaUtil.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class JpaUtil {
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("jpaPU");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
