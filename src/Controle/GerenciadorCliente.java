package Controle;



import java.util.ArrayList;
import java.util.List;

import Entidades.Cliente;
import Excecao.ExceptionGerenciadorCliente;

public class GerenciadorCliente {

	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	public void cadastrar(Cliente cliente){
		if(cliente.getNome() == null){
			throw new RuntimeException("O preenchimento do Nome é obrigatório");
		}
		if (cliente.getCpf() == null) {
			throw new RuntimeException("O preenchimento do Cpf é obrigatório");
		}
		if (cliente.getRua() == null) {
			throw new RuntimeException("O preenchimento da Rua é obrigatório");
		}
		if (cliente.getCidade() == null) {
			throw new RuntimeException("O preenchimento da Cidade é obrigatório");
		}
		if (cliente.getTelefone() == null) {
			throw new RuntimeException("O preenchimento do Telefone é obrigatório");
		}
		if (cliente.getEstado() == null) {
			throw new RuntimeException("O preenchimento do Estado é obrigatório");
		}
		if (cliente.getBairro() == null) {
			throw new RuntimeException("O preenchimento do Bairro é obrigatório");
		}
		if (cliente.getCep() == null) {
			throw new RuntimeException("O preenchimento do Cp é obrigatório");
		}
		if (cliente.getEmails() == null) {
			throw new RuntimeException("O preenchimento do Emails é obrigatório");
		}
		for (Cliente c : clientes) {
			if (c.getCpf().equals(cliente.getCpf())) {
				throw new RuntimeException("Cpf duplicado");
			}
		}
		
		clientes.add(cliente);
	}
	

	public List<Cliente> getClientes() {
		return clientes;
	}

	public Cliente pesquisarClientePorCpf(String cpf) {

		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf))
				return cliente;
		}
		throw new ExceptionGerenciadorCliente("Cpf invalido");
	}

	public Cliente pesquisarClientePorNome(String nome)
			throws ExceptionGerenciadorCliente {
		for (Cliente cliente : clientes) {
			if (cliente.getNome().equals(nome))
				return cliente;
		}
		return null;
	}

	public List<Cliente> pesquisaClientePorCategoria(String cli)
			throws ExceptionGerenciadorCliente {
		for (Cliente cliente : clientes) {
			if (cliente.getCategoria().equals(cli))
				return clientes;
		}
		return null;

	}

	public String removerCliente(String cpf) {

		Cliente cliente = this.pesquisarClientePorCpf(cpf);
		if (cliente.getCpf() != null) {
			this.clientes.remove(cliente);
			return cpf;
		} else {
			throw new ExceptionGerenciadorCliente("Cliente" + " nao encontrado");
		}

	}

	public Cliente editarCliente(Cliente c) {
		Cliente cliente = this.pesquisarClientePorCpf(c.getCpf());
		if (cliente.getCpf() != null) {
			cliente.setCpf(c.getCpf());
			cliente.setNome(c.getNome());
		}
		return cliente;

	}

	
}
