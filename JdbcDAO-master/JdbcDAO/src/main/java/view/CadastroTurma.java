package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.TurmasJdbcDAO;
import model.Turmas;

public class CadastroTurma extends JFrame {
	
	
	JTextField txtIdProfessor = new JTextField();
	JLabel idProfessor= new JLabel("idProfessor: ");
	
	JTextField txtIdCurso = new JTextField();
	JLabel idCurso = new JLabel("idCurso: ");

	JButton btnSalvar = new JButton("Salvar");
	

	public CadastroTurma(){
		super("Cadastro de Turmas");
		
		Container paine = this.getContentPane();
		
		paine.add(idProfessor);
		paine.add(txtIdProfessor);	
		idProfessor.setBounds(10, 15, 45, 30);
		txtIdProfessor.setBounds(90, 15, 225, 30);
		
		paine.add(idCurso);
		paine.add(txtIdCurso);	
		idCurso.setBounds(10, 50, 70, 30);
		txtIdCurso.setBounds(90, 50, 225, 30);	
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Turmas turma = new Turmas();
				turma.setIdProfessor(Integer.parseInt(txtIdProfessor.getText()));
				turma.setIdCurso(Integer.parseInt(txtIdCurso.getText()));
				

				Connection connection = JdbUtil.getConnection();
				TurmasJdbcDAO turmasJdbcDao = new TurmasJdbcDAO(connection);
				
				turmasJdbcDao.salvar(turma);
				
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
