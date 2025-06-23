
package br.com.barbearia.menu;

import br.com.barbearia.entity.Cliente;
import br.com.barbearia.entity.Funcionario;
import br.com.barbearia.entity.Servico;
import br.com.barbearia.repository.ClienteRepository;
import br.com.barbearia.repository.FuncionarioRepository;
import br.com.barbearia.repository.ServicoRepository;

public class TestesCRUD {

    public static void main(String[] args) {
        ClienteRepository clienteRepo = new ClienteRepository();
        FuncionarioRepository funcionarioRepo = new FuncionarioRepository();
        ServicoRepository servicoRepo = new ServicoRepository();

        // Cliente
        Cliente cliente = new Cliente();
        cliente.setNome("João da Silva");
        cliente.setTelefone("123456789");
        clienteRepo.salvar(cliente);

        // Funcionario
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Maria Oliveira");
        funcionario.setCargo("Cabeleireira");
        funcionarioRepo.salvar(funcionario);

        // Servico
        Servico servico = new Servico();
        servico.setDescricao("Corte Masculino");
        servico.setPreco(50.0);
        servicoRepo.salvar(servico);

        System.out.println("Dados inseridos com sucesso!");

        System.out.println("Clientes:");
        clienteRepo.listarTodos().forEach(c -> System.out.println(c.getNome()));

        System.out.println("Funcionários:");
        funcionarioRepo.listarTodos().forEach(f -> System.out.println(f.getNome()));

        System.out.println("Serviços:");
        servicoRepo.listarTodos().forEach(s -> System.out.println(s.getDescricao()));
    }
}
