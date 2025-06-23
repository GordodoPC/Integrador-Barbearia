
package br.com.barbearia.view;

import br.com.barbearia.entity.Funcionario;
import br.com.barbearia.repository.FuncionarioRepository;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroFuncionario extends JFrame {

    public TelaCadastroFuncionario() {
        setTitle("Cadastro de Funcionário");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField(20);

        JLabel lblCargo = new JLabel("Cargo:");
        JTextField txtCargo = new JTextField(20);

        JButton btnSalvar = new JButton("Salvar");

        btnSalvar.addActionListener(e -> {
            Funcionario funcionario = new Funcionario();
            funcionario.setNome(txtNome.getText());
            funcionario.setCargo(txtCargo.getText());

            FuncionarioRepository repo = new FuncionarioRepository();
            repo.salvar(funcionario);

            JOptionPane.showMessageDialog(this, "Funcionário salvo com sucesso!");
            dispose();
        });

        setLayout(new GridLayout(4, 2));
        add(lblNome); add(txtNome);
        add(lblCargo); add(txtCargo);
        add(new JLabel()); add(btnSalvar);
    }
}
