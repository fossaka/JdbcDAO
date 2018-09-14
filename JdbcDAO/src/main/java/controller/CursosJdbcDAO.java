package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cursos;

public class CursosJdbcDAO {

	private Connection conn;
	
	public CursosJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Cursos c) throws SQLException {
		String sql = "insert into tb_cursos (nmCurso, periodoCurso, duracao) values ('"+c.getNmCurso()+"','"+c.getPeriodoCurso()+"','"+c.getDuracao()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	}
	
	public void alterar(Cursos c) {
		String sql = "update tb_cursos set nmCurso='"+c.getNmCurso()+"',periodoCurso='"+c.getPeriodoCurso()+"',duracao='"+c.getDuracao()+"';";
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
	
	public void excluir(int idCurso) {
		String sql = "delete from tb_cursos where id='"+idCurso+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}
	
	public List<Cursos> listar() {
		String sql = "select * from tb_cursos";
        System.out.println(sql);		
        List<Cursos> cursosLista = new ArrayList<Cursos>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int idCurso = rs.getInt("idCurso");
				String nmCurso = rs.getString("nmCurso");
				String periodoCurso = rs.getString("periodoCurso");
				int duracao = rs.getInt("duracao");
				Cursos curso = new Cursos();
				curso.setIdCursos(idCurso);
				curso.setNmCurso(nmCurso);
				curso.setPeriodoCurso(periodoCurso);
				curso.setDuracao(duracao);
				
				cursosLista.add(curso);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cursosLista;
	}
	
}
