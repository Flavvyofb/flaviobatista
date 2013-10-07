package Controle;

import java.util.ArrayList;
import java.util.List;

import Entidades.Produto;


import Excecao.ExceptionGerenciadorProduto;


public class GerenciadorProduto {

	private List<Produto> produtos;

	public GerenciadorProduto() {

		produtos = new ArrayList<Produto>();

	}

	public void cadastrar(Produto produto) {
		if (produto.getNome() == null) {
			throw new RuntimeException("Preencimento do Nome é Obrigatorio");
		}
		if (produto.getCodigo() == null) {
			throw new RuntimeException("Preencimento do Codigo é Obrigatorio");
		}
		if (produto.getCategoria() == null) {
			throw new RuntimeException(
					"Preencimento do Cateforia é Obrigatorio");
		}
		if (produto.getDataVenc() == null) {
			throw new RuntimeException(
					"Preencimento da Data de Vencimento é Obrigatorio");
		}
		if (produto.getDataFab() == null) {
			throw new RuntimeException(
					"Preencimento da Data de Fabricacao é Obrigatorio");
		}
		if (produto.getFabricante() == null) {
			throw new RuntimeException(
					"Preencimento do Fabricante é Obrigatorio");
		}
		for (Produto p : produtos) {
			if (p.getCodigo().equals(produto.getCodigo())) {
				throw new RuntimeException("Codigo ja foi cadastrado");
			}
		}
		produtos.add(produto);

	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Produto pesquisarProdutoPorCodigo(String codigo) {
		for (Produto produto : produtos) {
			if (produto.getCodigo().equals(codigo))
				return produto;
		}
		throw new ExceptionGerenciadorProduto("Codigo Cadastrado");
	}

	public Produto pesquisaProdutoPorNome(String nome)
			throws ExceptionGerenciadorProduto {
		for (Produto produto : produtos) {
			if (produto.getNome().equals(nome))
				return produto;

		}
		return null;
	}

	public Produto editarProduto(Produto p2) {
		Produto produto = this.pesquisarProdutoPorCodigo(p2.getCodigo());
		if (produto.getCodigo() != null) {
			produto.setCodigo(p2.getCodigo());
			produto.setNome(p2.getNome());
			produto.setCategoria(p2.getCategoria());
		}
		return produto;
	}

	public void removeProduto(String codigo) {
		Produto produto = this.pesquisarProdutoPorCodigo(codigo);
		if (produto.getCodigo() != null) {
			this.produtos.remove(produto);
		} else {
			throw new ExceptionGerenciadorProduto("Produto nao Encontrado");
		}
	}

	//
	// public String removerFuncionario(String cpf) {
	// Funcionario funcionario = this.pesquisarFuncionarioPorCpf(cpf);
	// if (funcionario.getCpf() != null) {
	// this.funcionarios.remove(funcionario);
	// return cpf;
	// } else {
	// throw new ExceptionGerenciadorCliente("Funcionario" + " nao encontrado");
	// }
	// }
	//
	//
	// public Funcionario editarFuncionario(Funcionario f) {
	// Funcionario funcionario = this.pesquisarFuncionarioPorCpf(f.getCpf());
	// if (funcionario.getCpf() != null) {
	// funcionario.setCpf(f.getCpf());
	// funcionario.setNome(f.getNome());
	// }
	// return funcionario;
	//
	// }

}
