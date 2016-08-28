/**
 * 
 */
package br.com.fiap.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Aluno;

/**
 * simple-webapp / TestBean.java
 * FIAP / RM30222 - Vagner Panarello
 */

@ManagedBean
@RequestScoped
public class TestBean implements Serializable {

	private List<Aluno> retList;
	
	private String variable;
	
	public String getVariable() {
		return "Vagner Panarello";
	}

	
	
	public List<Aluno> getRetList() {
		
		GenericDao<Aluno> dao = new GenericDao<Aluno>(Aluno.class);
		
		
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		for(int i = 0; i < 5; i++) {
			Aluno aluno = new Aluno();
			aluno.setNome("Lonchas Silva");
			aluno.setMatricula("RM3022" + i);
			alunos.add(aluno);
			
			dao.adicionar(aluno);
		}
		
	
	
		
		return alunos;
	}

	public void setRetList(List<Aluno> retList) {
		this.retList = retList;
	}
	
	
	
	
	
	
	
	
}
