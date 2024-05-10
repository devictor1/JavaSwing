package aula0905;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;





public class LoginScreen extends JFrame implements ActionListener {

    private JTextField usernameField;

    private JPasswordField passwordField;

    private JButton loginButton;

    private JButton resetPasswordButton;



    public LoginScreen() {

        setTitle("Login");

        setSize(500, 350);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null); // Centralizar a tela



        JPanel panel = new JPanel(new GridLayout(3, 2));

        usernameField = new JTextField();
        usernameField.setHorizontalAlignment(SwingConstants.CENTER);

        passwordField = new JPasswordField();
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);

        loginButton = new JButton("Login");

        resetPasswordButton = new JButton("Resetar Senha");



        JLabel label = new JLabel("Usuário:");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        panel.add(usernameField);

        JLabel label_1 = new JLabel("Senha:");
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label_1);

        panel.add(passwordField);

        panel.add(loginButton);

        panel.add(resetPasswordButton);



        loginButton.addActionListener(this);

        resetPasswordButton.addActionListener(this);



        getContentPane().add(panel);

        setVisible(true);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                new LoginScreen();

            }

        });

    }

    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {

            String username = usernameField.getText();

            String password = new String(passwordField.getPassword());

            if (login(username, password)) {

                JOptionPane.showMessageDialog(this, "Login bem-sucedido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                dispose(); // Fechar a tela de login

                new MainMenuScreen().setVisible(true); // Abrir a próxima tela do menu principal

            } else {

                JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);

            }

        } else if (e.getSource() == resetPasswordButton) {
        	
        	
        	        		
        	String username = usernameField.getText();
        	
        	resetPassword(username);

        }

    }

    private boolean login(String username, String password) {

        String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";

        String user = "seu_usuario";

        String pass = "sua_senha";



        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            String query = "SELECT * FROM usuarios WHERE username=? AND password=?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, username);

            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
            // Se houver algum resultado, o login é válido

        } catch (SQLException ex) {

            ex.printStackTrace();

            return false;

        }

    }
    
    private void resetPassword(String username) {

        String newPassword = JOptionPane.showInputDialog("Digite a nova senha:");

        if (newPassword != null && !newPassword.isEmpty()) {

            String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";

            String user = "seu_usuario";

            String pass = "sua_senha";



            try {

                Connection connection = DriverManager.getConnection(url, user, pass);

                String query = "UPDATE usuarios SET password=? WHERE username=?";

                PreparedStatement statement = connection.prepareStatement(query);

                statement.setString(1, newPassword);

                statement.setString(2, username);

                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {

                    JOptionPane.showMessageDialog(this, "Senha resetada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                } else {

                    JOptionPane.showMessageDialog(this, "Usuário não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);

                }

            } catch (SQLException ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(this, "Erro ao resetar a senha!", "Erro", JOptionPane.ERROR_MESSAGE);

            }

        } else {

            JOptionPane.showMessageDialog(this, "Nova senha não pode ser vazia!", "Erro", JOptionPane.ERROR_MESSAGE);

        }

    }
}