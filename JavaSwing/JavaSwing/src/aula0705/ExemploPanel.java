package aula0705;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class ExemploPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsurio;
	private JTextField txtSenha;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public ExemploPanel() {
		setLayout(null);
		
		JTextArea txtrTitulo = new JTextArea();
		txtrTitulo.setText("Passa o login agora");
		txtrTitulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		txtrTitulo.setBounds(117, 11, 184, 42);
		add(txtrTitulo);
		
		txtUsurio = new JTextField();
		txtUsurio.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		txtUsurio.setEditable(false);
		txtUsurio.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsurio.setText("Usuário");
		txtUsurio.setBounds(170, 119, 86, 20);
		add(txtUsurio);
		txtUsurio.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setText("Senha");
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		txtSenha.setEditable(false);
		txtSenha.setColumns(10);
		txtSenha.setBounds(170, 175, 86, 20);
		add(txtSenha);
		
		textField = new JTextField();
		textField.setBounds(170, 144, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(170, 200, 86, 20);
		add(passwordField);
		
		JButton btnNewButton = new JButton("Entrar\r\n");
		btnNewButton.setBounds(170, 232, 86, 23);
		add(btnNewButton);
		
		JButton btnEsqueceuSuaSenha = new JButton("Esqueceu sua senha?");
		btnEsqueceuSuaSenha.setBounds(132, 262, 161, 23);
		add(btnEsqueceuSuaSenha);

	}
	 public static void main(String[] args) {
	        JFrame frame = new JFrame("Exemplo Panel");
	        ExemploPanel painel = new ExemploPanel();
	        
	        frame.getContentPane().add(painel);
	        frame.pack();
	        frame.setSize(500,500);
	        frame.setVisible(true);
	    }
}
