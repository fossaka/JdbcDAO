package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Alunos;


public class AlunosJdbcDAO {

	private Connection conn;
	
	
	public AlunosJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	public void salvar(Alunos c) throws SQLException {
		String sql = "insert into tb_aluno (nmAluno, endereco,idTurma) values ('"+c.getNmAluno()+"','"+c.getEnderecoAluno()+"','"+c.getIdTurma()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	}
	
	public void alterar(Alunos c) {
		String sql = "update tb_alunos set nmAluno = '"+c.getNmAluno()+"',endereco='"+c.getEnderecoAluno()+"',idTurma='"+c.getIdTurma()+"';";
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
	
	public void excluir(int idAluno) {
		String sql = "delete from tb_aluno where id='"+idAluno+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}
	
	public List<Alunos> listar() {
		String sql = "select * from tb_aluno";
        System.out.println(sql);		
        List<Alunos> listaAlunos = new ArrayList<Alunos>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int idAluno = rs.getInt("idAluno");
				String nmAluno = rs.getString("nmAluno");
				String endereco = rs.getString("endereco");
				int idTurma =rs.getInt("idTurma");
				Alunos aluno = new Alunos();
				aluno.setIdAlunos(idAluno);
				aluno.setNmAluno(nmAluno);
				aluno.setEnderecoAluno(endereco);
				aluno.setIdTurma(idTurma);
				
				listaAlunos.add(aluno);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAlunos;
	}
}