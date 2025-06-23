
package br.com.barbearia.view;

import br.com.barbearia.entity.Servico;
import br.com.barbearia.repository.ServicoRepository;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroServico extends JFrame {

    public TelaCadastroServico() {
        setTitle("Cadastro de Serviço");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JLabel lblDescricao = new JLabel("Descrição:");
        JTextField txtDescricao = new JTextField(20);

        JLabel lblPreco = new JLabel("Preço:");
        JTextField txtPreco = new JTextField(10);

        JButton btnSalvar = new JButton("Salvar");

        btnSalvar.addActionListener(e -> {
            Servico servico = new Servico();
            servico.setDescricao(txtDescricao.getText());
            try {
                servico.setPreco(Double.parseDouble(txtPreco.getText()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Preço inválido!");
                return;
            }

            ServicoRepository repo = new ServicoRepository();
            repo.salvar(servico);

            JOptionPane.showMessageDialog(this, "Serviço salvo com sucesso!");
            dispose();
        });

        setLayout(new GridLayout(4, 2));
        add(lblDescricao); add(txtDescricao);
        add(lblPreco); add(txtPreco);
        add(new JLabel()); add(btnSalvar);
    }
}
