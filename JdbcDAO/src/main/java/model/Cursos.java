package model;

public class Cursos {

	private int idCurso;
	private String nmCurso;
	private String periodoCurso;
	private int duracao;
	
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCursos(Integer idCurso) {
		this.idCurso = idCurso;
	}
	
	public String getNmCurso() {
		return nmCurso;
	}
	public void setNmCurso(String nmCurso) {
		this.nmCurso = nmCurso;
	}
	
	public String getPeriodoCurso() {
		return periodoCurso;
	}
	public void setPeriodoCurso(String periodoCurso) {
		this.periodoCurso = periodoCurso;
	}
	
	public Integer getDuracao() {
		return duracao;
	}
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
}
