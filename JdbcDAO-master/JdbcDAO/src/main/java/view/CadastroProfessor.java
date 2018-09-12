package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ProfessoresJdbcDAO;
import controller.JdbUtil;
import model.Professores;;

public class CadastroProfessor extends JFrame {
	
		JTextField txtNmProfessor = new JTextField();
		JLabel nomeProfessor = new JLabel("Nome do Professor: ");
		
		JTextField txtCpf = new JTextField();
		JLabel cpf = new JLabel("CPF: ");
		
		JTextField txtIdTurma = new JTextField();
		JLabel idTurma = new JLabel("Turma: ");

		JButton btnSalvar = new JButton("Salvar");
		

		public CadastroProfessor(){
			super("Cadastro Professor");
			
			Container ProfessorPaine = this.getContentPane();
			
			ProfessorPaine.add(nomeProfessor);
			ProfessorPaine.add(txtNmProfessor);	
			nomeProfessor.setBounds(10, 15, 45, 30);
			txtNmProfessor.setBounds(90, 15, 225, 30);
			
			ProfessorPaine.add(cpf);
			ProfessorPaine.add(txtCpf);	
			cpf.setBounds(10, 50, 70, 30);
			txtCpf.setBounds(90, 50, 225, 30);	
			
			ProfessorPaine.add(btnSalvar);
			btnSalvar.setBounds(250, 250, 130, 30);
			btnSalvar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try {
					Professores professor = new Professores();
					professor.setNmProfessor(txtNmProfessor.getText());
					professor.setCpf(Integer.parseInt(txtCpf.getText()));
					

					Connection connection = JdbUtil.getConnection();
					ProfessoresJdbcDAO professoresJdbcDao = new ProfessoresJdbcDAO(connection);
					
					professoresJdbcDao.salvar(professor);
					
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
