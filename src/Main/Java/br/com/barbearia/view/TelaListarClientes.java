
package br.com.barbearia.view;

import br.com.barbearia.entity.Cliente;
import br.com.barbearia.repository.ClienteRepository;

import javax.swing.*;
import java.util.List;

public class TelaListarClientes extends JFrame {

    public TelaListarClientes() {
        setTitle("Lista de Clientes");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        ClienteRepository repo = new ClienteRepository();
        List<Cliente> clientes = repo.listarTodos();

        for (Cliente c : clientes) {
            textArea.append(c.getNome() + " - " + c.getTelefone() + "\n");
        }

        add(new JScrollPane(textArea));
    }
}
