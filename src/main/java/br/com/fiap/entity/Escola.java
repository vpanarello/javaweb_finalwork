/**
 * 
 */
package br.com.fiap.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * simple-webapp / Escola.java
 * FIAP / RM30222 - Vagner Panarello
 */

@Entity
@Table(name="escolas")
public class Escola {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="nome")
	private String nome;

	@Column(name="endereco")
	private String endereco;

	@OneToMany(mappedBy="escola")
	Set<Professor> professores;

	@OneToMany(mappedBy="escola")
	Set<Curso> cursos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Set<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(Set<Professor> professores) {
		this.professores = professores;
	}
	
	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}


}
