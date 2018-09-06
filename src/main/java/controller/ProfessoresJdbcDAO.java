package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Professores;

public class ProfessoresJdbcDAO {
	
	private Connection conn;
	
	public void salvar(Professores c) throws SQLException {
		String sql = "insert into tb_professores (nmProfessor, cpf, idTurma) values ('"+c.getnmProfessor()+"','"+c.getCpf()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	}
	
	public void alterar(Professores c) {
		String sql = "update tb_professores set nmProfessor='"+c.getnmProfessor()+"',cpf='"+c.getCpf()+"';";
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
	
	public void excluir(int idProfessor) {
		String sql = "delete from tb_professores where id='"+idProfessor+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}
	
	public List<Professores> listar() {
		String sql = "select * from tb_professores";
        System.out.println(sql);		
        List<Professores> professorList = new ArrayList<Professores>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int idProfessor = rs.getInt("idProfessor");
				String nmProfessor = rs.getString("nmProfessor");
				Integer cpf = rs.getInt("cpf");
				Professores professor = new Professores();
				professor.setIdProfessor(idProfessor);
				professor.setNmProfessor(nmProfessor);
				professor.setCpf(cpf);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return professorList;
	}
}
