package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class App extends JFrame {
	
	JButton btnCurso = new JButton("Cadastro Curso");
	JButton btnTurma = new JButton("Cadastro Turma");
	JButton btnAluno = new JButton("Cadastro Aluno");
	JButton btnProfessor = new JButton("Cadastro Professor");
	JButton btnSalvar = new JButton("Salvar");
	
	public App(){
		super("Ápì");
			
		Container paine = this.getContentPane();
		
		paine.add(btnProfessor);
		paine.add(btnAluno);
		paine.add(btnTurma);
		paine.add(btnCurso);
		
		btnProfessor.setBounds(200,150, 130, 30);
		btnProfessor.addActionListener(new ActionListener(){
				
			public void actionPerformed(ActionEvent e) {
				CadastroProfessor cadastroProfessor = new CadastroProfessor();
				cadastroProfessor.setVisible(true);
			}
		});
		
		btnCurso.setBounds(400,150, 130, 30);
		btnCurso.addActionListener(new ActionListener(){
				
			public void actionPerformed(ActionEvent e) {
				CadastroCurso cadastroCurso = new CadastroCurso();
				cadastroCurso.setVisible(true);
			}
		});
		
		btnTurma.setBounds(200,250, 130, 30);
		btnTurma.addActionListener(new ActionListener(){
				
			public void actionPerformed(ActionEvent e) {
				CadastroTurma cadastroTurma = new CadastroTurma();
				cadastroTurma.setVisible(true);
			}
		});
		
		btnAluno.setBounds(400,250, 130, 30);
		btnAluno.addActionListener(new ActionListener(){
				
			public void actionPerformed(ActionEvent e) {
				CadastroAluno cadastroAluno = new CadastroAluno();
				cadastroAluno.setVisible(true);
			}
		});
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(600, 330);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main( String[] args ){
		App app = new App();

}
}