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

import controller.CursosJdbcDAO;
import controller.JdbUtil;
import controller.ProfessoresJdbcDAO;
import model.Cursos;
import model.Professores;

public class CadastroCurso extends JFrame {

	JComboBox<String> cboCursos = new JComboBox<String>();
	JLabel listaCadastro = new JLabel("Lista de Cursos Cadastrados");
	
	JTextField txtIdCurso = new JTextField();
	JLabel idCurso= new JLabel("Id: ");
	
	JTextField txtNmCurso = new JTextField();
	JLabel nmCurso = new JLabel("Nome: ");
	
	JTextField txtPeriodoCurso= new JTextField();
	JLabel periodoCurso= new JLabel("Periodo: ");

	JTextField txtDuracaoCurso = new JTextField();
	JLabel duracaoCurso = new JLabel("Duracao:");
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnAlterar = new JButton("Alterar");

	public CadastroCurso(){
		super("Cadastro de Cursos");
		
		Container paine = this.getContentPane();
		paine.add(listaCadastro);
		listaCadastro.setBounds(40, 2, 200, 20);
		paine.add(cboCursos);
		cboCursos.setBounds(65,25,150,20);
		
		cboCursos.addItem("");
		
		try {

			Connection connection = JdbUtil.getConnection();
			CursosJdbcDAO cursosJdbcDAO = new CursosJdbcDAO(connection);
			
			List<Cursos> listaCursos = cursosJdbcDAO.listar();
			
			for (int i = 0; i < listaCursos.size(); i++) {
				cboCursos.addItem(listaCursos.get(i).getNmCurso());
			}
			
			cboCursos.addItemListener(new ItemListener(){
			       public void itemStateChanged(ItemEvent ie){
			    	   
			            String str = (String)cboCursos.getSelectedItem();

			           txtNmCurso.setText(str);
			       }
				});  
			
			System.out.println(listaCursos);
			
			paine.add(idCurso);
			paine.add(txtIdCurso);
			idCurso.setBounds(10, 70, 70, 25);
			txtIdCurso.setBounds(90, 70, 160, 25);
			txtIdCurso.setEditable(false);
			
			paine.add(nmCurso);
			paine.add(txtNmCurso);	
			nmCurso.setBounds(10, 100, 70, 25);
			txtNmCurso.setBounds(90, 100, 160, 25);
			
			paine.add(periodoCurso);
			paine.add(txtPeriodoCurso);	
			periodoCurso.setBounds(10, 130, 70, 25);
			txtPeriodoCurso.setBounds(90, 130, 160, 25);
			
			paine.add(duracaoCurso);
			paine.add(txtDuracaoCurso);
			duracaoCurso.setBounds(10, 160, 70, 25);
			txtDuracaoCurso.setBounds(90, 160, 160, 25);
			
			paine.add(btnSalvar);
			
			btnSalvar.setBounds(20, 250, 110, 30);
			btnSalvar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try {
					Cursos cursos = new Cursos();
					cursos.setNmCurso(txtNmCurso.getText());
					cursos.setPeriodoCurso(txtPeriodoCurso.getText());
					cursos.setDuracao(Integer.parseInt(txtDuracaoCurso.getText()));
					
					Connection connection = JdbUtil.getConnection();
					CursosJdbcDAO cursosJdbcDao = new CursosJdbcDAO(connection);
					
					cursosJdbcDao.salvar(cursos);
					
							
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
