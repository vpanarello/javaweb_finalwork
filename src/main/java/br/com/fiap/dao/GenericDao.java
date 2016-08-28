/**
 * 
 */
package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * simple-webapp / GenericDao.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class GenericDao<T> implements Dao<T> {
	
	private final Class<T> classe;
	protected EntityManager em;
	
	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}


	public void adicionar(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
		
	}


	@SuppressWarnings("unchecked")
	public List<T> listar() {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName()).getResultList();
	}


	public T buscar(int id) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(classe, id);
		em.getTransaction().commit();
		em.close();

		return entidade;
	}
}
