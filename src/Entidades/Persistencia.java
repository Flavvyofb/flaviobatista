package Entidades;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;


public class Persistencia implements Serializable {

	
	List<Cliente> clientes = new ArrayList<Cliente>();
	List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	List<Produto> produtos = new ArrayList<Produto>();
	
	public Persistencia() {
		this.clientes = new ArrayList<Cliente>();
		this.fornecedores = new ArrayList<Fornecedor>();
		this.funcionarios = new ArrayList<Funcionario>();
		this.produtos = new ArrayList<Produto>();

	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}


	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	
	public List<Produto> getProdutos() {
		return produtos;
	}

	
	
	
}
