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
			throw new RuntimeException("O preenchimento do Nome é obrigatório");
		}
		if (funcionario.getCpf() == null) {
			throw new RuntimeException("O preenchimento do Cpf é obrigatório");
		}
		if (funcionario.getRua() == null) {
			throw new RuntimeException("O preenchimento da Rua é obrigatório");
		}
		if (funcionario.getCidade() == null) {
			throw new RuntimeException(
					"O preenchimento da Cidade é obrigatório");
		}
		if (funcionario.getTelefone() == null) {
			throw new RuntimeException(
					"O preenchimento do Telefone é obrigatório");
		}
		if (funcionario.getEstado() == null) {
			throw new RuntimeException(
					"O preenchimento do Estado é obrigatório");
		}
		if (funcionario.getBairro() == null) {
			throw new RuntimeException(
					"O preenchimento do Bairro é obrigatório");
		}
		if (funcionario.getCep() == null) {
			throw new RuntimeException("O preenchimento do Cp é obrigatório");
		}
		if (funcionario.getEmails() == null) {
			throw new RuntimeException(
					"O preenchimento do Emails é obrigatório");
		}
		if (funcionario.getId() == null) {
			throw new RuntimeException("O preenchimento do Id é obrigatório");
		}
		if (funcionario.getBanco() == null) {
			throw new RuntimeException("O preenchimento do Banco é obrigatório");
		}
		if (funcionario.getAgencia() == null) {
			throw new RuntimeException(
					"O preenchimento da Agencia é obrigatório");
		}
		if (funcionario.getContacorrente() == null) {
			throw new RuntimeException(
					"O preenchimento do Emails é obrigatório");
		}
		if (funcionario.getContatos() == null) {
			throw new RuntimeException(
					"O preenchimento do Emails é obrigatório");
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
