package Controle;



import java.util.ArrayList;
import java.util.List;

import Entidades.Cliente;
import Excecao.ExceptionGerenciadorCliente;

public class GerenciadorCliente {

	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	public void cadastrar(Cliente cliente){
		if(cliente.getNome() == null){
			throw new RuntimeException("O preenchimento do Nome � obrigat�rio");
		}
		if (cliente.getCpf() == null) {
			throw new RuntimeException("O preenchimento do Cpf � obrigat�rio");
		}
		if (cliente.getRua() == null) {
			throw new RuntimeException("O preenchimento da Rua � obrigat�rio");
		}
		if (cliente.getCidade() == null) {
			throw new RuntimeException("O preenchimento da Cidade � obrigat�rio");
		}
		if (cliente.getTelefone() == null) {
			throw new RuntimeException("O preenchimento do Telefone � obrigat�rio");
		}
		if (cliente.getEstado() == null) {
			throw new RuntimeException("O preenchimento do Estado � obrigat�rio");
		}
		if (cliente.getBairro() == null) {
			throw new RuntimeException("O preenchimento do Bairro � obrigat�rio");
		}
		if (cliente.getCep() == null) {
			throw new RuntimeException("O preenchimento do Cp � obrigat�rio");
		}
		if (cliente.getEmails() == null) {
			throw new RuntimeException("O preenchimento do Emails � obrigat�rio");
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
