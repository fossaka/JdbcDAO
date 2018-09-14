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

import controller.ProfessoresJdbcDAO;
import controller.JdbUtil;
import model.Professores;

/**
 * Hello world!
 *
 */

public class CadastroProfessor extends JFrame
{
	JComboBox<String> cboProfessor = new JComboBox<String>();
	JLabel listaCadastro = new JLabel("Lista de Professores Cadastrados");
	
	JTextField txtIdProfessor = new JTextField();
	JLabel idProfessor = new JLabel("Id: ");
	
	JTextField txtNmProfessor = new JTextField();
	JLabel nmProfessor = new JLabel("Nome: ");
	
	JTextField txtCpf = new JTextField();
	JLabel cpf = new JLabel("Cpf: ");

	JButton btnSalvar = new JButton("Salvar");
	JButton btnAlterar = new JButton("Alterar");

	public CadastroProfessor(){
		super("Cadastro de Professor");
		
		Container paine = this.getContentPane();
		paine.add(listaCadastro);
		listaCadastro.setBounds(40, 2, 200, 20);
		paine.add(cboProfessor);
		cboProfessor.setBounds(65,25,150,20);
		
		cboProfessor.addItem("");
		
		try {

			Connection connection = JdbUtil.getConnection();
			ProfessoresJdbcDAO professoresJdbcDAO = new ProfessoresJdbcDAO(connection);
			
			List<Professores> listaProfessores = professoresJdbcDAO.listar();
			
			for (int i = 0; i < listaProfessores.size(); i++) {
				cboProfessor.addItem(listaProfessores.get(i).getnmProfessor());
			}
			
			cboProfessor.addItemListener(new ItemListener(){
			       public void itemStateChanged(ItemEvent ie){
			    	   
			            String str = (String)cboProfessor.getSelectedItem();

			           txtNmProfessor.setText(str);
			       }
				});  
			
			System.out.println(listaProfessores);
			
			paine.add(idProfessor);
			paine.add(txtIdProfessor);
			idProfessor.setBounds(10, 70, 70, 25);
			txtIdProfessor.setBounds(90, 70, 160, 25);
			txtIdProfessor.setEditable(false);
			
			paine.add(nmProfessor);
			paine.add(txtNmProfessor);	
			nmProfessor.setBounds(10, 100, 70, 25);
			txtNmProfessor.setBounds(90, 100, 160, 25);
			
			paine.add(cpf);
			paine.add(txtCpf);	
			cpf.setBounds(10, 130, 70, 25);
			txtCpf.setBounds(90, 130, 160, 25);
			
			paine.add(btnSalvar);
			
			btnSalvar.setBounds(20, 250, 110, 30);
			btnSalvar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try {
					Professores professores = new Professores();
					professores.setNmProfessor(txtNmProfessor.getText());
					professores.setCpf(Integer.parseInt(txtCpf.getText()));
					
					Connection connection = JdbUtil.getConnection();
					ProfessoresJdbcDAO professoresJdbcDao = new ProfessoresJdbcDAO(connection);
					
					professoresJdbcDao.salvar(professores);
					
							
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
