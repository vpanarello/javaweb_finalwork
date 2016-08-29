/**
 * 
 */
package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Notas;

/**
 * simple-webapp / DefinedAlunosDao.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class DefinedAlunosDao extends GenericDao<Aluno> {
	
//	private final Class<T> classe;
	protected EntityManager em;

	public DefinedAlunosDao(Class<Aluno> classe) {
		super(classe);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> buscaDisciplinasPorAlunoId(int id) {
		em = JpaUtil.getEntityManager();
		return (List<Disciplina>) em.createQuery("select d from Disciplina d INNER JOIN d.curso c INNER JOIN c.alunos a WHERE a.id IN (:id)")
				.setParameter("id", id).getResultList();
	
	}
	
	@SuppressWarnings("unchecked")
	public List<Notas> buscaNotasPorAlunoId(int id) {
		em = JpaUtil.getEntityManager();
		return (List<Notas>) em.createQuery("select n from Notas n INNER JOIN n.aluno a WHERE a.id =:id")
				.setParameter("id", id).getResultList();
	}
	
	
	
	

}
