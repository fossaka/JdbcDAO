package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.AlunosJdbcDAO;
import controller.ProfessoresJdbcDAO;
import controller.JdbUtil;
import model.Alunos;
import model.Professores;

/**
 * Hello world!
 *
 */
public class CadastroAluno extends JFrame
{
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME: ");
	
	JTextField txtEnd = new JTextField();
	JLabel end = new JLabel("ENDEREÇO: ");
	
	JTextField txtIdTurma = new JTextField();
	JLabel idTurma = new JLabel("IDTURMA: ");

	JButton btnSalvar = new JButton("Salvar");
	JButton btnProfessor = new JButton("Professor");
	

	public CadastroAluno(){
		super("Cadastro Alunos");
		
		Container paine = this.getContentPane();
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(90, 15, 225, 30);
		
		paine.add(end);
		paine.add(txtEnd);	
		end.setBounds(10, 50, 70, 30);
		txtEnd.setBounds(90, 50, 225, 30);
		
		paine.add(idTurma);
		paine.add(txtIdTurma);
		idTurma.setBounds(10, 85, 225, 30);
		txtIdTurma.setBounds(90, 85, 225, 30);
		
		
	
		paine.add(btnSalvar);
		
		btnSalvar.setBounds(250, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Alunos alunos = new Alunos();
				alunos.setNmAluno(txtNome.getText());
				alunos.setEnderecoAluno(txtEnd.getText());

				Connection connection = JdbUtil.getConnection();
				AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
				
				alunosJdbcDao.salvar(alunos);
				
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
