package Controle;

import java.util.ArrayList;
import java.util.List;


import Entidades.Funcionario;

import Excecao.ExceptionGerenciadorCliente;

import Excecao.ExceptionGerenciadorFuncionario;

public class GerenciadorFuncionario {

	private List<Funcionario> funcionarios;

	public GerenciadorFuncionario() {

		funcionarios = new ArrayList<Funcionario>();

	}

	public void cadastrar(Funcionario funcionario) {
		if (funcionario.getNome() == null) {
			throw new RuntimeException("O preenchimento do Nome � obrigat�rio");
		}
		if (funcionario.getCpf() == null) {
			throw new RuntimeException("O preenchimento do Cpf � obrigat�rio");
		}
		if (funcionario.getRua() == null) {
			throw new RuntimeException("O preenchimento da Rua � obrigat�rio");
		}
		if (funcionario.getCidade() == null) {
			throw new RuntimeException(
					"O preenchimento da Cidade � obrigat�rio");
		}
		if (funcionario.getTelefone() == null) {
			throw new RuntimeException(
					"O preenchimento do Telefone � obrigat�rio");
		}
		if (funcionario.getEstado() == null) {
			throw new RuntimeException(
					"O preenchimento do Estado � obrigat�rio");
		}
		if (funcionario.getBairro() == null) {
			throw new RuntimeException(
					"O preenchimento do Bairro � obrigat�rio");
		}
		if (funcionario.getCep() == null) {
			throw new RuntimeException("O preenchimento do Cp � obrigat�rio");
		}
		if (funcionario.getEmails() == null) {
			throw new RuntimeException(
					"O preenchimento do Emails � obrigat�rio");
		}
		if (funcionario.getId() == null) {
			throw new RuntimeException("O preenchimento do Id � obrigat�rio");
		}
		if (funcionario.getBanco() == null) {
			throw new RuntimeException("O preenchimento do Banco � obrigat�rio");
		}
		if (funcionario.getAgencia() == null) {
			throw new RuntimeException(
					"O preenchimento da Agencia � obrigat�rio");
		}
		if (funcionario.getContacorrente() == null) {
			throw new RuntimeException(
					"O preenchimento do Emails � obrigat�rio");
		}
		if (funcionario.getContatos() == null) {
			throw new RuntimeException(
					"O preenchimento do Emails � obrigat�rio");
		}
		for (Funcionario f : funcionarios) {
			if (f.getCpf().equals(funcionario.getCpf())) {
				throw new RuntimeException("Cpf duplicado");
			}
		}

		funcionarios.add(funcionario);
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public Funcionario pesquisarFuncionarioPorCpf(String cpf) {

		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getCpf().equals(cpf))
				return funcionario;
		}
		throw new ExceptionGerenciadorCliente("Cpf invalido");
	}
	
	public Funcionario pesquisarFuncionarioPorNome(String nome)
	throws ExceptionGerenciadorFuncionario {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getNome().equals(nome))
				return funcionario;
		}
		return null;
	}
	
	public String removerFuncionario(String cpf) {
		Funcionario funcionario = this.pesquisarFuncionarioPorCpf(cpf);
		if (funcionario.getCpf() != null) {
			this.funcionarios.remove(funcionario);
			return cpf;
		} else {
			throw new ExceptionGerenciadorCliente("Funcionario" + " nao encontrado");
		}
	}
	
	
	public Funcionario editarFuncionario(Funcionario f) {
		Funcionario funcionario = this.pesquisarFuncionarioPorCpf(f.getCpf());
		if (funcionario.getCpf() != null) {
			funcionario.setCpf(f.getCpf());
			funcionario.setNome(f.getNome());
		}
		return funcionario;

	}

}
