
package br.com.barbearia.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Barbearia - Sistema");
        setSize(350, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
        JButton btnListarClientes = new JButton("Listar Clientes");
        JButton btnCadastrarFuncionario = new JButton("Cadastrar Funcionário");
        JButton btnCadastrarServico = new JButton("Cadastrar Serviço");

        btnCadastrarCliente.addActionListener(e -> new TelaCadastroCliente().setVisible(true));
        btnListarClientes.addActionListener(e -> new TelaListarClientes().setVisible(true));
        btnCadastrarFuncionario.addActionListener(e -> new TelaCadastroFuncionario().setVisible(true));
        btnCadastrarServico.addActionListener(e -> new TelaCadastroServico().setVisible(true));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(btnCadastrarCliente);
        panel.add(btnListarClientes);
        panel.add(btnCadastrarFuncionario);
        panel.add(btnCadastrarServico);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }
}
