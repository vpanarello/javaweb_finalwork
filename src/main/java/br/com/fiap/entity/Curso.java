/**
 * 
 */
package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * simple-webapp / Curso.java
 * FIAP / RM30222 - Vagner Panarello
 */

@Entity
@Table(name="cursos")
public class Curso {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="id")
		private int id;

		@Column(name="nome")
		private String nome;
		
		@Column(name="codigo")
		private String codigo;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="escola_id")
		private Escola escola;
		
		@OneToMany(mappedBy="curso")
		private List<Disciplina> disciplinas;
		
		@OneToMany(mappedBy="curso")
		private List<Aluno> alunos;

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

		public String getCodigo() {
			return codigo;
		}

		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}

		public Escola getEscola() {
			return escola;
		}

		public void setEscola(Escola escola) {
			this.escola = escola;
		}

		public List<Disciplina> getDisciplinas() {
			return disciplinas;
		}

		public void setDisciplinas(List<Disciplina> disciplinas) {
			this.disciplinas = disciplinas;
		}

		public List<Aluno> getAlunos() {
			return alunos;
		}

		public void setAlunos(List<Aluno> alunos) {
			this.alunos = alunos;
		}

}
