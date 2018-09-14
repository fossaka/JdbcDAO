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

import controller.JdbUtil;
import controller.ProfessoresJdbcDAO;
import controller.TurmasJdbcDAO;
import model.Professores;
import model.Turmas;

public class CadastroTurma extends JFrame {
	
	JComboBox<String> cboTurmas = new JComboBox<String>();
	JLabel listaCadastro = new JLabel("Lista de Turmas Cadastradas");
	
	JTextField txtIdTurma= new JTextField();
	JLabel idTurma = new JLabel("Id: ");
	
	JTextField txtNmTurma = new JTextField();
	JLabel nmTurma = new JLabel("Nome: ");
	
	JTextField txtIdProfessor= new JTextField();
	JLabel idProfessor = new JLabel("Id Prof.: ");
	
	JTextField txtIdCurso = new JTextField();
	JLabel idCurso = new JLabel("Id Curso: ");

	JButton btnSalvar = new JButton("Salvar");
	JButton btnAlterar = new JButton("Alterar");	

	public CadastroTurma(){
		super("Cadastro de Turmas");
		
		Container paine = this.getContentPane();
		paine.add(listaCadastro);
		listaCadastro.setBounds(40, 2, 200, 20);
		paine.add(cboTurmas);
		cboTurmas.setBounds(65,25,150,20);
		
		cboTurmas.addItem("");
		
		try {

			Connection connection = JdbUtil.getConnection();
			TurmasJdbcDAO turmasJdbcDAO = new TurmasJdbcDAO(connection);
			
			List<Turmas> listaTurmas = turmasJdbcDAO.listar();
			
			for (int i = 0; i < listaTurmas.size(); i++) {
				cboTurmas.addItem(listaTurmas.get(i).getNmTurma());
			}
			
			cboTurmas.addItemListener(new ItemListener(){
			       public void itemStateChanged(ItemEvent ie){
			    	   
			            String str = (String)cboTurmas.getSelectedItem();

			           txtIdTurma.setText(str);
			       }
				});  
			
			System.out.println(listaTurmas);
			
			paine.add(idTurma);
			paine.add(txtIdTurma);
			idTurma.setBounds(10, 70, 70, 25);
			txtIdTurma.setBounds(90, 70, 160, 25);
			txtIdTurma.setEditable(false);
			
			paine.add(nmTurma);
			paine.add(txtNmTurma);
			nmTurma.setBounds(10, 100, 70, 25);
			txtNmTurma.setBounds(90, 100, 160, 25);
			
			
			paine.add(idProfessor);
			paine.add(txtIdProfessor);	
			idProfessor.setBounds(10, 130, 70, 25);
			txtIdProfessor.setBounds(90, 130, 160, 25);
			
			paine.add(idCurso);
			paine.add(txtIdCurso);	
			idCurso.setBounds(10, 160, 70, 25);
			txtIdCurso.setBounds(90, 160, 160, 25);
			
			paine.add(btnSalvar);
			
			btnSalvar.setBounds(20, 250, 110, 30);
			btnSalvar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try {
					Turmas turmas = new Turmas();
					turmas.setNmTurma(txtNmTurma.getText());
					turmas.setIdProfessor(Integer.parseInt(txtIdProfessor.getText()));
					turmas.setIdCurso(Integer.parseInt(txtIdCurso.getText()));
					
					Connection connection = JdbUtil.getConnection();
					TurmasJdbcDAO turmasJdbcDao = new TurmasJdbcDAO(connection);
					
					turmasJdbcDao.salvar(turmas);
					
							
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
