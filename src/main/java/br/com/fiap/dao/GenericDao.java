/**
 * 
 */
package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Escola;
import br.com.fiap.entity.Professor;

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
	
	@SuppressWarnings("unchecked")
	public T buscarPorNome(String nome) {
		em = JpaUtil.getEntityManager();
		
		if(this.classe == Aluno.class){
			
		} else if  (this.classe == Curso.class) {
			return (T) em.createQuery("select c from Curso c where c.nome = :nome")
					.setParameter("nome", nome).getResultList().get(0);
		} else if  (this.classe == Disciplina.class) {
			return (T) em.createQuery("select d from Disciplina d where d.nome = :nome")
					.setParameter("nome", nome).getResultList().get(0);
		} else if  (this.classe == Escola.class) {
			return (T) em.createQuery("select e from Escola e where e.nome = :nome")
					.setParameter("nome", nome).getResultList().get(0);
		} else if  (this.classe == Professor.class) {
			return (T) em.createQuery("select p from Professor p where p.nome = :nome")
					.setParameter("nome", nome).getResultList().get(0);
		}
		return null;
	}
	
	
}
