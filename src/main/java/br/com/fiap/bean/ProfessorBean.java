/**
 * 
 */
package br.com.fiap.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.Dao;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Escola;
import br.com.fiap.entity.Professor;

/**
 * simple-webapp / CursoBean.java
 * FIAP / RM30222 - Vagner Panarello
 */


@ManagedBean
@RequestScoped
public class ProfessorBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Professor professor;

	private int status;

	private String nomeEscola;
	

	public ProfessorBean() {
		super();
		this.status = 0;
		this.professor = new Professor();
		this.nomeEscola = "";
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public String cadastrar() {


		try {
			GenericDao<Escola> escolaDao = new GenericDao<Escola>(Escola.class);
			Escola escola = escolaDao.buscarPorNome(this.nomeEscola);


			Dao<Professor> dao = new GenericDao<Professor>(Professor.class);
			
			this.professor.setEscola(escola);
			escola.getProfessores().add(professor);
			
			dao.adicionar(this.professor);

			this.status = 1;

			return "cadastro-professores";
		} catch (Exception e) {
			e.printStackTrace();
			return "falha";
		}
	}

	public List<Professor> listar(){
		Dao<Professor> dao = new GenericDao<Professor>(Professor.class);		
		return dao.listar();
	}
	
public Set<String> getComboBox() {
		
		Set<String> lista = new HashSet<String>();
		
		for(Professor var : this.listar()) {
			lista.add(var.getNome());
		}
		return lista;
	}
}

