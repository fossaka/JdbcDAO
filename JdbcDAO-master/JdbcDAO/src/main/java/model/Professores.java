package model;

public class Professores {
	
	private int idProfessor;
	private String nmProfessor;
	private int cpf;
	private int idTurma;
	

	public Integer getIdProfessor() {
		return idProfessor;
	}
	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}
	public String getnmProfessor() {
		return nmProfessor;
	}
	public void setNmProfessor(String nmProfessor) {
		this.nmProfessor = nmProfessor;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public int getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}
}
