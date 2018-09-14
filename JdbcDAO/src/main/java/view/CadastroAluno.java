package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
	JComboBox<String> cboAluno = new JComboBox<String>();
	JLabel listaCadastro = new JLabel("Lista de Alunos Cadastrados");
	
	JTextField txtIdAluno = new JTextField();
	JLabel idAluno = new JLabel("Id: ");
	
	JTextField txtNmAluno = new JTextField();
	JLabel nmAluno = new JLabel("Nome: ");
	
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
				cboAluno.addItem(listaAlunos.get(i).getNmAluno());
				
				System.out.println(listaAlunos);
			}
			
			cboAluno.addItemListener(new ItemListener(){
			       public void itemStateChanged(ItemEvent ie){
			    	   
			            String str = (String)cboAluno.getSelectedItem();

			           txtNmAluno.setText(str);
			       }
				});  
			
			paine.add(idAluno);
			paine.add(txtIdAluno);
			idAluno.setBounds(10, 70, 45, 25);
			txtIdAluno.setBounds(90, 70, 160, 25);
			txtIdAluno.setEditable(false);
			
			paine.add(nmAluno);
			paine.add(txtNmAluno);	
			nmAluno.setBounds(10,100, 45, 25);
			txtNmAluno.setBounds(90, 100, 160, 25);
			
			paine.add(end);
			paine.add(txtEnd);	
			end.setBounds(10, 130, 70, 25);
			txtEnd.setBounds(90, 130, 160, 25);
			
			paine.add(idTurma);
			paine.add(txtIdTurma);
			idTurma.setBounds(10, 160, 225, 25);
			txtIdTurma.setBounds(90, 160, 160, 25);
			
			paine.add(btnSalvar);
			
			btnSalvar.setBounds(20, 250, 110, 30);
			btnSalvar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try {
					Alunos alunos = new Alunos();
					alunos.setNmAluno(txtNmAluno.getText());
					alunos.setEnderecoAluno(txtEnd.getText());
					alunos.setIdTurma(Integer.parseInt(txtIdTurma.getText()));
					
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
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(300, 330);
	}
}
