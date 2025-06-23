
package br.com.barbearia.view;

import br.com.barbearia.entity.Cliente;
import br.com.barbearia.repository.ClienteRepository;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroCliente extends JFrame {

    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField(20);

        JLabel lblTelefone = new JLabel("Telefone:");
        JTextField txtTelefone = new JTextField(15);

        JButton btnSalvar = new JButton("Salvar");

        btnSalvar.addActionListener(e -> {
            Cliente cliente = new Cliente();
            cliente.setNome(txtNome.getText());
            cliente.setTelefone(txtTelefone.getText());

            ClienteRepository repo = new ClienteRepository();
            repo.salvar(cliente);

            JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!");
            dispose();
        });

        setLayout(new GridLayout(4, 2));
        add(lblNome); add(txtNome);
        add(lblTelefone); add(txtTelefone);
        add(new JLabel()); add(btnSalvar);
    }
}
