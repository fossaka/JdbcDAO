package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Turmas;;

public class TurmasJdbcDAO {

private Connection conn;
	
public TurmasJdbcDAO(Connection conn) {
	this.conn = conn;
}


	public void salvar(Turmas c) throws SQLException {
		String sql = "insert into tb_turmas (nmTurma, idProfessor,  idCurso) values ('"+c.getNmTurma()+"','"+c.getIdProfessor()+"','"+c.getIdCurso()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	}
	
	public void alterar(Turmas c) {
		String sql = "update tb_turmas set nmTurma='"+c.getNmTurma()+"', idProfessor='"+c.getIdProfessor()+"', idCurso='"+c.getIdCurso()+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
            prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void excluir(int idTurmas) {
		String sql = "delete from tb_turmas where id='"+idTurmas+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}
	
	public List<Turmas> listar() {
		String sql = "select * from tb_turmas";
        System.out.println(sql);		
        List<Turmas> listaTurmas = new ArrayList<Turmas>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				
				int idTurma = rs.getInt("idTurma");
				String nmTurma = rs.getString("nmTurma");
				int idProfessor = rs.getInt("idProfessor");
				int idCurso =rs.getInt("idCurso");
				
				Turmas turma = new Turmas();
				
				turma.setIdTurmas(idTurma);
				turma.setNmTurma(nmTurma);
				turma.setIdProfessor(idProfessor);
				turma.setIdCurso(idCurso);
				
				listaTurmas.add(turma);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTurmas;
	}
	
	public List<Turmas> listaSpec(String c){
		String sql = "select * from tb_turmas nmTurma = '""'";
		List<Turmas> listaTurmas = new ArrayList<Turmas>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			
		}
	}
}
