package Fachada;

import java.util.List;

import Controle.GerenciadorCliente;
import Controle.GerenciadorFornecedor;
import Controle.GerenciadorFuncionario;
import Controle.GerenciadorProduto;
import Entidades.Cliente;
import Entidades.Fornecedor;
import Entidades.Funcionario;
import Entidades.Produto;

import Excecao.ExceptionGerenciadorCliente;
import Excecao.ExceptionGerenciadorFornecedor;
import Excecao.ExceptionGerenciadorFuncionario;
import Excecao.ExceptionGerenciadorProduto;

public class Loja {

  GerenciadorFornecedor gFornecedor = new GerenciadorFornecedor();
  GerenciadorFuncionario gFunc = new GerenciadorFuncionario();
  GerenciadorCliente gCliente = new GerenciadorCliente();
  GerenciadorProduto gProduto = new GerenciadorProduto();
  
  
   // Cliente


	public GerenciadorCliente getgCliente() {
		return gCliente;
	}

	public GerenciadorProduto getgProduto() {
		return gProduto;
	}

	public void setgCliente(GerenciadorCliente gCliente) {
		this.gCliente = gCliente;
	}

	public void cadastrar(Cliente cliente) {
		gCliente.cadastrar(cliente);
	}

	public List<Cliente> listarClientes() {
		return gCliente.getClientes();
	}

	public void remove(String cpf) {
		gCliente.removerCliente(cpf);

	}

	public Cliente pesquisaClienteCpf(String cpf)
			throws ExceptionGerenciadorCliente {
		return gCliente.pesquisarClientePorCpf(cpf);
	}

	public Cliente pesquisaClienteNome(String nome)
			throws ExceptionGerenciadorCliente {
		return gCliente.pesquisarClientePorNome(nome);

	}

	public List<Cliente> pesquisaClienteCategoria(String categoria)
			throws ExceptionGerenciadorCliente {
		return gCliente.pesquisaClientePorCategoria(categoria);

	}

	public Cliente editarCliente(Cliente c) {
		return gCliente.editarCliente(c);

	}



// Fornecedor
	
	

	public GerenciadorFornecedor getgFornecedor() {
		return gFornecedor;
	}

	public void setgFornecedor(GerenciadorFornecedor gFornecedor) {
		this.gFornecedor = gFornecedor;
	}

	public void cadastrar(Fornecedor fornecedor) {
		gFornecedor.cadastrar(fornecedor);
	}

	public List<Fornecedor> listarFornecedor() {
		return gFornecedor.getFornecedores();
	}

	public void removeFornecedor(String string)
			throws ExceptionGerenciadorFornecedor {
		gFornecedor.removerFornecedor(string);

	}

	public Fornecedor pesquisaFornecedorCnpj(String cnpj)
			throws ExceptionGerenciadorFornecedor {
		return gFornecedor.pesquisarFornecedorPorCnpj(cnpj);

	}

	public Fornecedor pesquisaFornecedorNome(String nome)
			throws ExceptionGerenciadorFornecedor {
		return gFornecedor.pesquisarFornecedorPorNome(nome);
	}

	public Fornecedor pesquisaFornecedorId(String id)
			throws ExceptionGerenciadorFornecedor {
		return gFornecedor.pesquisarFornecedorId(id);
	}

	public Fornecedor editarFornecedor(Fornecedor f) {

		return gFornecedor.editaFornecedor(f);
	}


	
	// Funcionario
  
  
	public GerenciadorFuncionario getgFunc() {
		return gFunc;
	}

	public void setgFunc(GerenciadorFuncionario gFunc) {
		this.gFunc = gFunc;
	}

	public void cadastrar(Funcionario funcionario1) {
		gFunc.cadastrar(funcionario1);

	}

	public List<Funcionario> listarFuncionario() {
		return gFunc.getFuncionarios();
	}

	public void removeFuncionario(String cpf) {
		gFunc.removerFuncionario(cpf);

	}

	public Funcionario pesquisaFuncionarioCpf(String cpf)
			throws ExceptionGerenciadorFuncionario {
		return gFunc.pesquisarFuncionarioPorCpf(cpf);

	}

	public Funcionario pesquisaFuncionarioNome(String nome)
			throws ExceptionGerenciadorFuncionario {
		return gFunc.pesquisarFuncionarioPorNome(nome);
	}

	public Funcionario editarFuncionario(Funcionario func2) {
		return gFunc.editarFuncionario(func2);
	}

	
	// Produto
	
	public GerenciadorProduto getProduto() {
		return gProduto;
	}

	public void setgProduto(GerenciadorProduto gProduto) {
		this.gProduto = gProduto;
	}

	public void cadastrar(Produto produto) {
		gProduto.cadastrar(produto);

		}
	public List<Produto> listarProduto() {
		return gProduto.getProdutos();
	}

	public Produto pesquisaProdutoCodigo(String codigo) 
		throws ExceptionGerenciadorProduto{
		return gProduto.pesquisarProdutoPorCodigo(codigo);
	}

	public Produto pesquisaProdutoNome(String nome) 
		throws ExceptionGerenciadorProduto{
		return gProduto.pesquisaProdutoPorNome(nome);
		
	}

	public Produto editarProduto(Produto p2) {
		
		return gProduto.editarProduto(p2);
	}

	public void removeProduto(String codigo) {
		gProduto.removeProduto(codigo);
		
	}
	
	
}
	

	
	
	
	


    
  

  

 