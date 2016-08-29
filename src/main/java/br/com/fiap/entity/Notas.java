/**
 * 
 */
package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * simple-webapp / Aluno.java
 * FIAP / RM30222 - Vagner Panarello
 */

@Entity
@Table(name="notas")
public class Notas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="nota_01")
	private float projeto01;
	
	@Column(name="nota_02")
	private float atividadePratica;
	
	@Column(name="nota_03")
	private float projeto02;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="aluno_id")
	private Aluno aluno;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="disciplina_id")
	private Disciplina disciplina;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getProjeto01() {
		return projeto01;
	}

	public void setProjeto01(float projeto01) {
		this.projeto01 = projeto01;
	}

	public float getAtividadePratica() {
		return atividadePratica;
	}

	public void setAtividadePratica(float atividadePratica) {
		this.atividadePratica = atividadePratica;
	}

	public float getProjeto02() {
		return projeto02;
	}

	public void setProjeto02(float projeto02) {
		this.projeto02 = projeto02;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}


}
