package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.CursosJdbcDAO;
import controller.JdbUtil;
import model.Cursos;

public class CadastroCurso extends JFrame {

	JTextField txtNmCurso = new JTextField();
	JLabel nmCurso= new JLabel("nmCurso: ");
	
	JTextField txtPeriodoCurso = new JTextField();
	JLabel periodoCurso= new JLabel("periodoCurso: ");
	
	JTextField txtDuracao = new JTextField();
	JLabel duracao = new JLabel("duracao: ");

	JButton btnSalvar = new JButton("Salvar");
	

	public CadastroCurso(){
		super("Cadastro de Cursos");
		
		Container paine = this.getContentPane();
		
		paine.add(nmCurso);
		paine.add(txtNmCurso);	
		nmCurso.setBounds(10, 15, 45, 30);
		txtNmCurso.setBounds(90, 15, 225, 30);
		
		paine.add(periodoCurso);
		paine.add(txtPeriodoCurso);	
		periodoCurso.setBounds(10, 50, 70, 30);
		txtPeriodoCurso.setBounds(90, 50, 225, 30);	
		
		paine.add(duracao);
		paine.add(txtDuracao);
		duracao.setBounds(10,75,70,30);
		txtDuracao.setBounds(90,75,70,30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Cursos curso = new Cursos();
				
				curso.setNmCurso(txtNmCurso.getText());
				curso.setPeriodoCurso(txtPeriodoCurso.getText());
				curso.setDuracao(Integer.parseInt(txtDuracao.getText()));

				Connection connection = JdbUtil.getConnection();
				CursosJdbcDAO cursosJdbcDao = new CursosJdbcDAO(connection);
				
				cursosJdbcDao.salvar(curso);
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(600, 330);
	}
	
}
