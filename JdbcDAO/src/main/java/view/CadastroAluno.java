package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Alunos;

/**
 * Hello world!
 *
 */

public class CadastroAluno extends JFrame
{
	JComboBox cboAluno = new JComboBox();
	JLabel listaCadastro = new JLabel("Lista de Alunos Cadastrados");
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("Nome: ");
	
	JTextField txtEnd = new JTextField();
	JLabel end = new JLabel("Endereço: ");
	
	JTextField txtIdTurma = new JTextField();
	JLabel idTurma = new JLabel("Id Turma: ");

	JButton btnSalvar = new JButton("Salvar");
	JButton btnAlterar = new JButton("Alterar");

	public CadastroAluno(){
		super("Cadastro Alunos");
		
		Container paine = this.getContentPane();
		paine.add(listaCadastro);
		listaCadastro.setBounds(60, 2, 200, 20);
		paine.add(cboAluno);
		cboAluno.setBounds(65,25,150,20);
		
		cboAluno.addItem("");
		
		try {

			Connection connection = JdbUtil.getConnection();
			AlunosJdbcDAO alunoJdbcDAO = new AlunosJdbcDAO(connection);
			
			List<Alunos> listaAlunos = alunoJdbcDAO.listar();
			for (int i = 0; i < listaAlunos.size(); i++) {
				cboAluno.addItem(listaAlunos.get(0).getNmAluno());
			}
			
			nome.setBounds(20, 50, 150, 20);
			paine.add(nome);
			
			txtNome.setBounds(160, 50, 150, 20);
			paine.add(txtNome);
			
			end.setBounds(20, 80, 150, 20);
			paine.add(end);
			
			txtEnd.setBounds(160, 80, 150, 20);
			paine.add(txtEnd);
			
			idTurma.setBounds(20, 110, 150, 20);
			paine.add(idTurma);
			
			txtIdTurma.setBounds(160, 110, 150, 20);
			paine.add(txtIdTurma);
			
			btnSalvar.setBounds(100, 160, 150, 50);
			paine.add(btnSalvar);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 70, 45, 25);
		txtNome.setBounds(90, 70, 160, 25);
		//txtNome.setBounds(x, y, width, height);
		paine.add(end);
		paine.add(txtEnd);	
		end.setBounds(10, 100, 70, 25);
		txtEnd.setBounds(90, 100, 160, 25);
		
		paine.add(idTurma);
		paine.add(txtIdTurma);
		idTurma.setBounds(10, 130, 225, 25);
		txtIdTurma.setBounds(90, 130, 160, 25);
		
		paine.add(btnSalvar);
		
		btnSalvar.setBounds(20, 250, 110, 30);
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
		paine.add(btnAlterar);
		
		btnAlterar.setBounds(140, 250, 110, 30);
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(300, 330);
	}
}
