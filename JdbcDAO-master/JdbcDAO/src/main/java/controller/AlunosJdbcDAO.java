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
		String sql = "insert into tb_alunos (nmAluno, enderecoAluno,idTurma) values ('"+c.getNmAluno()+"','"+c.getEnderecoAluno()+"','"+c.getIdTurma()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	}
	
	public void alterar(Alunos c) {
		String sql = "update tb_alunos set nmAluno='"+c.getNmAluno()+"',enderecoAluno='"+c.getEnderecoAluno()+"',idTurma='"+c.getIdTurma()+"';";
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
		String sql = "delete from tb_alunos where id='"+idAluno+"';";
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
		String sql = "select * from alunos";
        System.out.println(sql);		
        List<Alunos> listaAlunos = new ArrayList<Alunos>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int idAluno = rs.getInt("idAluno");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				int idTurma =rs.getInt("idTurma");
				Alunos aluno = new Alunos();
				aluno.setIdAlunos(idAluno);
				aluno.setNmAluno(nome);
				aluno.setEnderecoAluno(endereco);
				aluno.setIdTurma(idTurma);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAlunos;
	}
}