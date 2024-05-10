package aula0905;

import javax.swing.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



public class MainMenuScreen extends JFrame {

    public MainMenuScreen() {

        setTitle("Menu Principal");

        setSize(400, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null); // Centralize a tela



        JMenuBar menuBar = new JMenuBar();

        JMenu menuOpcoes = new JMenu("Opções");

        JMenuItem opcao1 = new JMenuItem("Opção 1");

        JMenuItem opcao2 = new JMenuItem("Opção 2");

        JMenuItem opcao3 = new JMenuItem("Opção 3");

        JMenuItem opcao4 = new JMenuItem("Opção 4");

        JMenuItem opcao5 = new JMenuItem("Opção 5");

        menuOpcoes.add(opcao1);

        menuOpcoes.add(opcao2);

        menuOpcoes.add(opcao3);

        menuOpcoes.add(opcao4);

        menuOpcoes.add(opcao5);

        menuBar.add(menuOpcoes);



        JButton botaoSair = new JButton("Sair do Sistema");

        botaoSair.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }

        });



        JPanel panel = new JPanel();

        panel.add(botaoSair);



        setJMenuBar(menuBar);

        add(panel);

    }

}



