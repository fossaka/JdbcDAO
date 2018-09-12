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
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME: ");
	
	JTextField txtEnd = new JTextField();
	JLabel end = new JLabel("ENDEREÇO: ");
	
	JTextField txtIdTurma = new JTextField();
	JLabel idTurma = new JLabel("IDTURMA: ");

	JButton btnSalvar = new JButton("Salvar");

	public CadastroAluno(){
		super("Cadastro Alunos");
		
		Container paine = this.getContentPane();
		
		paine.add(cboAluno);
		cboAluno.setBounds(160,20,150,20);
		
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
