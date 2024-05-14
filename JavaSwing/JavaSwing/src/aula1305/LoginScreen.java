/* Curso de Tecnologia - Análise e Desenvolvimento de Sistemas
 * Nome do Desenvolvedor: Victor Fregni Gogorza
 * Versão 1.0
*/

package aula1305;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginScreen {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;

	public LoginScreen() {

		frame = new JFrame("Tela de Login"); // Criação do Frame, da Tela em si

		frame.setSize(500, 500); // Dimensionando a tela
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Se certificando que vai fechar certo

		JPanel panel = new JPanel(); // Novo painel

		JLabel usernameLabel = new JLabel("Usuário");// Label que indica usuário
		usernameField = new JTextField(30);// Campo que usuário coloca seu username
		JLabel passwordLabel = new JLabel("Senha");// Label que indica senha
		passwordField = new JPasswordField(30);// Campo que o usuário coloca a sua senha

		JButton loginButton = new JButton("Logar");// Botão para logar
		JButton registerButton = new JButton("Registre-se");// Botão para se registrar

		loginButton.addActionListener(new ActionListener() { // Conexão com o banco de dados

			@Override
			public void actionPerformed(ActionEvent e) {

				String username = usernameField.getText();
				char[] password = passwordField.getPassword();

				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
					Statement statement = connection.createStatement();

					ResultSet resultSet = statement.executeQuery("SELECT*FROM user WHERE username =" + username
							+ "AND password=" + new String(password) + "");
					if (resultSet.next()) {
						System.out.println("LAPADA TOME VAI LOGA");
					} else {
						System.out.println("VAZA DAQUI ZE");

					}
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		});
		panel.add(usernameLabel);
		panel.add(usernameField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(loginButton);
		panel.add(registerButton);

		frame.add(panel);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new LoginScreen();
	}
}
