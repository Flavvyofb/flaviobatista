package Controle;

import java.util.ArrayList;
import java.util.List;


import Entidades.Fornecedor;
import Excecao.ExceptionGerenciadorCliente;
import Excecao.ExceptionGerenciadorFornecedor;

public class GerenciadorFornecedor {

	private List<Fornecedor> fornecedores;

	public GerenciadorFornecedor() {

		fornecedores = new ArrayList<Fornecedor>();

	}

	public void cadastrar(Fornecedor fornecedor) {
		if (fornecedor.getNome() == null) {
			throw new RuntimeException("O preenchimento do Nome � obrigat�rio");
		}
		if (fornecedor.getCnpj() == null) {
			throw new RuntimeException("O preenchimento do CNPJ � obrigat�rio");
		}
		
		if (fornecedor.getRua() == null) {
			throw new RuntimeException("O preenchimento da Rua � obrigat�rio");
		}
		if (fornecedor.getCidade() == null) {
			throw new RuntimeException(
					"O preenchimento da Cidade � obrigat�rio");
		}
		if (fornecedor.getTelefone() == null) {
			throw new RuntimeException(
					"O preenchimento do Telefone � obrigat�rio");
		}
		if (fornecedor.getEstado() == null) {
			throw new RuntimeException(
					"O preenchimento do Estado � obrigat�rio");
		}
		if (fornecedor.getBairro() == null) {
			throw new RuntimeException(
					"O preenchimento do Bairro � obrigat�rio");
		}
		if (fornecedor.getCep() == null) {
			throw new RuntimeException("O preenchimento do Cp � obrigat�rio");
		}
		if (fornecedor.getEmails() == null) {
			throw new RuntimeException(
					"O preenchimento do Emails � obrigat�rio");
		}
		
		if (fornecedor.getId() == null) {
			throw new RuntimeException(
					"O preenchimento do ID s � obrigat�rio");
		}
		if (fornecedor.getEmails() == null) {
			throw new RuntimeException(
					"O preenchimento do Emails � obrigat�rio");
		}
		if (fornecedor.getBanco() == null) {
			throw new RuntimeException(
					"O preenchimento do Banco � obrigat�rio");
		}
		if (fornecedor.getAgencia() == null) {
			throw new RuntimeException(
					"O preenchimento da Agencia � obrigat�rio");
		}
		if (fornecedor.getContacorrente() == null) {
			throw new RuntimeException(
					"O preenchimento da Conta Corrente � obrigat�rio");
		}
		for (Fornecedor f : fornecedores) {
			if (f.getCnpj().equals(fornecedor.getCnpj())) {
				throw new RuntimeException("CNPJ duplicado");
			}
		}

		fornecedores.add(fornecedor);
	}

	public Fornecedor getFornecedor(Fornecedor fornecedor)
			throws ExceptionGerenciadorFornecedor {
		for (Fornecedor f : fornecedores) {
			if (f.equals(fornecedor)) {
				return f;
			}
		}
		throw new ExceptionGerenciadorFornecedor("Fornecedor n�o cadastrado");
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	
		
	public Fornecedor pesquisarFornecedorPorCnpj(String cnpj){
			
		for (Fornecedor fornecedor : fornecedores) {
			if (fornecedor.getCnpj().equals(cnpj))
				return fornecedor;
		}
		throw new ExceptionGerenciadorCliente("Cnpf invalido");
	}

	public Fornecedor pesquisarFornecedorPorNome(String nome)
			throws ExceptionGerenciadorFornecedor {
		for (Fornecedor fornecedor : fornecedores) {
			if (fornecedor.getNome().equals(nome))
				return fornecedor;
		}
		return null;
	}

	public Fornecedor pesquisarFornecedorId(String id)
			throws ExceptionGerenciadorFornecedor {
		for (Fornecedor fornecedor : fornecedores) {
			if (fornecedor.getId().equals(id))
				;
			return fornecedor;
		}
		return null;
	}
	
	public String removerFornecedor(String cnpj) {

		Fornecedor fornecedor = this.pesquisarFornecedorPorCnpj(cnpj);
		if (fornecedor.getCnpj() != null) {
			this.fornecedores.remove(fornecedor);
			return cnpj;
		} else {
			throw new ExceptionGerenciadorCliente("Cliente" + " nao encontrado");
		}

	}

	public Fornecedor editaFornecedor(Fornecedor f) {
		Fornecedor fornecedor = this.pesquisarFornecedorPorCnpj(f.getCnpj());
		if (fornecedor.getCnpj() != null) {
			fornecedor.setCpf(f.getCnpj());
			fornecedor.setNome(f.getNome());
		}
		return fornecedor;

	}
}
