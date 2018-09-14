package model;

public class Turmas {
	
	private int idTurmas;
	private String nmTurma;
	private int idProfessor;
	private int idCurso;
	
	
	public String getNmTurma() {
		return nmTurma;
	}
	
	public void setNmTurma(String nmTurma) {
		this.nmTurma = nmTurma;
	}
	public Integer getIdTurmas() {
		return idTurmas;
	}
	public void setIdTurmas(Integer idTurmas) {
		this.idTurmas = idTurmas;
	}
	
	public Integer getIdProfessor() {
		return idProfessor;
	}
	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}
	
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	
}
