package Teste;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Controle.GerentePersistencia;
import Entidades.Cliente;
import Entidades.Fornecedor;
import Entidades.Funcionario;
import Entidades.Produto;

import Excecao.ExceptionGerenciadorCliente;
import Excecao.ExceptionGerenciadorFornecedor;
import Excecao.ExceptionGerenciadorFuncionario;
import Excecao.ExceptionGerenciadorProduto;
import Fachada.Loja;

@SuppressWarnings("unused")
public class Teste {

	Loja fachada;

	
	@Before
	public void criarFachadaLoja() {
		
		GerentePersistencia.reset();
		fachada = new Loja();
	}

	@After
	public void fim() throws IOException {
	GerentePersistencia.apagarConteudoArquivo();

	}
	
	
	Cliente c;
	Cliente c2;

	Fornecedor f;
	Fornecedor f2;

	Funcionario func;
	Funcionario func2;

	Produto p;
	Produto p2;

	List<Cliente> listaCliente = null;
	List<Fornecedor> listaFornecedor = null;
	List<Funcionario> listaFuncionarios = null;
	List<Produto> listaProdutos = null;

	@Before
	public void CriarFachada() {

		fachada = new Loja();
		c = new Cliente();
		c2 = new Cliente();

		p = new Produto();
		p2 = new Produto();

		f = new Fornecedor();
		f2 = new Fornecedor();

		func = new Funcionario();
		func2 = new Funcionario();

		listaFornecedor = new ArrayList<Fornecedor>();
		listaCliente = new ArrayList<Cliente>();
		listaFuncionarios = new ArrayList<Funcionario>();
		listaProdutos = new ArrayList<Produto>();

	}

	private Cliente criarClientePadraoUm() {

		c.setNome("Flavio");
		c.setCpf("11111111111");
		c.setCidade("Jacarau");
		c.setRua("Treze de Maio");
		c.setNumero(97);
		c.setBairro("Centro");
		c.setCep("123");
		c.setEstado("PB");
		c.setEmails("flavio.batista@dce.ufpb.br");
		c.setCategoria("A");
		return c;

	}

	private Cliente criarClientePadraoDois() {

		c2.setNome("Renata");
		c2.setCpf("20000000000");
		c2.setCidade("Jacarau");
		c2.setRua("Treze de Maio");
		c2.setNumero(97);
		c2.setBairro("Centro");
		c2.setCep("123");
		c2.setEstado("PB");
		c2.setEmails("flavio.batista@dce.ufpb.br");
		c2.setCategoria("B");
		return c2;

	}

	@Test(expected = Exception.class)
	public void cadastrarCliente() {

		Cliente cliente1 = new Cliente();
		cliente1.setNome("flavio");
		cliente1.setCpf("123");
		Assert.assertNotNull(cliente1.getCpf());

		fachada.cadastrar(cliente1);
		Assert.assertEquals(1, fachada.getgCliente().getClientes().size());

	}

	@Test(expected = Exception.class)
	public void cadastrarMesmoCliente() {

		c = criarClientePadraoUm();
		fachada.cadastrar(c);
		fachada.cadastrar(c);
	}

	@Test(expected = Exception.class)
	public void pesquisaClientePorCpf() {

		c = criarClientePadraoUm();
		fachada.cadastrar(c);
		Cliente c2 = fachada.pesquisaClienteCpf(c.getCpf());

		Assert.assertEquals(c, c2);

	}

	@Test(expected = Exception.class)
	public void pesquisarComCpfInexistente() {

		c = criarClientePadraoUm();
		fachada.cadastrar(c);
		fachada.pesquisaClienteCpf("0000000");

	}

	@Test(expected = Exception.class)
	public void pesquisaClientePorNome() {

		c = criarClientePadraoUm();

		fachada.cadastrar(c);
		fachada.pesquisaClienteNome("Flavio");

		List<Cliente> clientes = fachada.listarClientes();

		Cliente clientePesquisado = clientes.get(0);
		Assert.assertEquals(clientePesquisado,
				fachada.pesquisaClienteNome("Flavio"));

	}

	@Test(expected = Exception.class)
	public void alterarNomeCliente() {

		c = criarClientePadraoUm();
		fachada.cadastrar(c);

		c2 = criarClientePadraoDois();
		fachada.cadastrar(c2);

		c2 = fachada.editarCliente(c);
		Assert.assertEquals("Flavio", c2.getNome());

	}

	@Test(expected = Exception.class)
	public void alterarCpfCliente() {

		c = criarClientePadraoUm();
		fachada.cadastrar(c);

		c2 = criarClientePadraoDois();
		fachada.cadastrar(c2);

		c2 = fachada.editarCliente(c);
		Assert.assertEquals("11111111111", c2.getCpf());
	}

	@Test(expected = Exception.class)
	public void addClienteNomeNulo() {

		c = criarClientePadraoUm();
		c.setNome(null);
		fachada.cadastrar(c);
	}

	@Test(expected = Exception.class)
	public void addClienteCpfNulo() {

		c = criarClientePadraoUm();
		c.setCpf(null);
		fachada.cadastrar(c);
	}

	@Test(expected = Exception.class)
	public void addClienteCidadeNulo() {

		c = criarClientePadraoUm();
		c.setCidade(null);
		fachada.cadastrar(c);
	}

	@Test(expected = Exception.class)
	public void addClienteRuaNulo() {

		c = criarClientePadraoUm();
		c.setRua(null);
		fachada.cadastrar(c);
	}

	@Test(expected = Exception.class)
	public void addClienteBairroNulo() {

		c = criarClientePadraoUm();
		c.setBairro(null);
		fachada.cadastrar(c);
	}

	@Test(expected = Exception.class)
	public void addClienteCepNulo() {

		c = criarClientePadraoUm();
		c.setCep(null);
		fachada.cadastrar(c);
	}

	@Test(expected = Exception.class)
	public void addClienteEstadoNulo() {

		c = criarClientePadraoUm();
		c.setEstado(null);
		fachada.cadastrar(c);
	}

	@Test(expected = Exception.class)
	public void addClienteEmailsNulo() {

		c = criarClientePadraoUm();
		c.setEmails(null);
		fachada.cadastrar(c);
	}

	@Test(expected = Exception.class)
	public void removeCliente() {

		c = criarClientePadraoUm();

		fachada.cadastrar(c);
		fachada.remove(c.getCpf());
	}

	@Test(expected = ExceptionGerenciadorCliente.class)
	public void removerClienteNaoExistente() {

		c = criarClientePadraoUm();
		Cliente c1 = new Cliente();
		c1.setCpf("12");

		fachada.remove(c1.getCpf());
	}

	/*
	 * --------------- TESTES -------Fornecedor
	 * __________________________________________________________________
	 */

	private Fornecedor criarFornecedorPadraoUm() {

		f.setNome("Amanco");
		f.setCnpj("111");
		f.setWebsites("Amanco.com");
		f.setTelefone("111");
		f.setCidade("Sao Paulo");
		f.setBairro("Morumbi");
		f.setRua("Tricolor");
		f.setNumero(3);
		f.setCep("111");
		f.setContacorrente("123454");
		f.setAgencia("111");
		f.setBanco("Banco do Brasil");
		f.setId("111");

		return f;
	}

	private Fornecedor criarFornecedorPadraoDois() {

		f2.setNome("Amanco");
		f2.setCpf("111");
		f2.setTelefone("111");
		f2.setCidade("Sao Paulo");
		f2.setBairro("Morumbi");
		f2.setRua("Tricolor");
		f2.setNumero(3);
		f2.setCep("111");
		f2.setContacorrente("123454");
		f2.setAgencia("111");
		f2.setBanco("Banco do Brasil");
		f2.setId("111");

		return f2;
	}

	@Test(expected = Exception.class)
	public void cadastrarFornecedor() {

		Fornecedor fornecedor1 = new Fornecedor();
		fornecedor1.setNome("Tigre");
		fornecedor1.setCnpj("12311");

		fachada.cadastrar(fornecedor1);

		Assert.assertEquals(1, fachada.getgFornecedor().getFornecedores()
				.size());

	}

	@Test(expected = Exception.class)
	public void cadastrarMesmoFornecedor() {

		f = criarFornecedorPadraoUm();
		fachada.cadastrar(f);
		fachada.cadastrar(f);
	}

	@Test(expected = Exception.class)
	public void pesquisaFornecedorPorCnpj() {

		f = criarFornecedorPadraoUm();

		fachada.cadastrar(f);
		Fornecedor f2 = fachada.pesquisaFornecedorCnpj(f.getCnpj());

		Assert.assertEquals(f, f2);

	}

	@Test(expected = Exception.class)
	public void pesquisarCnpjInexistente() {

		f = criarFornecedorPadraoUm();
		fachada.cadastrar(f);
		fachada.pesquisaFornecedorCnpj("");

	}

	@Test(expected = Exception.class)
	public void pesquisaFornecedorPorNome() {

		f = criarFornecedorPadraoUm();

		fachada.cadastrar(f);
		fachada.pesquisaFornecedorNome("Amanco");

		List<Fornecedor> fornecedores = fachada.listarFornecedor();

		Fornecedor fornecedorPesquisado = fornecedores.get(0);
		Assert.assertEquals(fornecedorPesquisado,
				fachada.pesquisaClienteNome("Amanco"));

	}

	@Test(expected = Exception.class)
	public void alterarNomeFornecedor() {

		f = criarFornecedorPadraoUm();
		fachada.cadastrar(f);

		f2 = criarFornecedorPadraoDois();
		fachada.cadastrar(f2);

		f2 = fachada.editarFornecedor(f);
		Assert.assertEquals("Amanco", f2.getNome());

	}

	@Test(expected = Exception.class)
	public void alterarCnpjFornecedor() {

		f = criarFornecedorPadraoUm();
		fachada.cadastrar(f);

		f2 = criarFornecedorPadraoDois();
		fachada.cadastrar(f2);

		f2 = fachada.editarFornecedor(f);
		Assert.assertEquals("111", f2.getCnpj());
	}

	@Test(expected = Exception.class)
	public void addFornecedorNomeNulo() {

		f = criarFornecedorPadraoUm();
		f.setNome(null);
		fachada.cadastrar(f);
	}

	@Test(expected = Exception.class)
	public void addFornecedorCnpjNulo() {

		f = criarFornecedorPadraoUm();
		f.setCnpj(null);
		fachada.cadastrar(f);
	}

	@Test(expected = Exception.class)
	public void addFornecedorCidadeNulo() {

		f = criarFornecedorPadraoUm();
		f.setCidade(null);
		fachada.cadastrar(f);
	}

	@Test(expected = Exception.class)
	public void addFornecedorRuaNulo() {

		f = criarFornecedorPadraoUm();
		f.setRua(null);
		fachada.cadastrar(f);
	}

	@Test(expected = Exception.class)
	public void addFornecedorBairroNulo() {

		f = criarFornecedorPadraoUm();
		f.setBairro(null);
		fachada.cadastrar(f);
	}

	@Test(expected = Exception.class)
	public void addFornecedorCepNulo() {

		f = criarFornecedorPadraoUm();
		f.setCep(null);
		fachada.cadastrar(f);
	}

	@Test(expected = Exception.class)
	public void addFornecedorEstadoNulo() {

		f = criarFornecedorPadraoUm();
		f.setEstado(null);
		fachada.cadastrar(f);
	}

	@Test(expected = Exception.class)
	public void addFornecedorEmailsNulo() {

		f = criarFornecedorPadraoUm();
		f.setEmails(null);
		fachada.cadastrar(f);
	}

	@Test(expected = Exception.class)
	public void addFornecedorId() {

		f = criarFornecedorPadraoUm();
		f.setId(null);
		fachada.cadastrar(f);
	}

	@Test(expected = Exception.class)
	public void addFornecedorBanco() {

		f = criarFornecedorPadraoUm();
		f.setBanco(null);
		fachada.cadastrar(f);
	}

	@Test(expected = Exception.class)
	public void addFornecedorAgencia() {

		f = criarFornecedorPadraoUm();
		f.setAgencia(null);
		fachada.cadastrar(f);
	}

	@Test(expected = Exception.class)
	public void addFornecedorContaCorrente() {

		f = criarFornecedorPadraoUm();
		f.setContacorrente(null);
		fachada.cadastrar(f);
	}

	@Test(expected = Exception.class)
	public void addFornecedorTelefone() {

		f = criarFornecedorPadraoUm();
		f.setTelefone(null);
		fachada.cadastrar(f);
	}

	@Test(expected = Exception.class)
	public void removeFornecedor() {

		f = criarFornecedorPadraoUm();

		fachada.cadastrar(f);
		fachada.removeFornecedor(f.getCnpj());

	}

	@Test(expected = ExceptionGerenciadorCliente.class)
	public void removerFornecedorNaoExistente() {

		f = criarFornecedorPadraoUm();
		Fornecedor f1 = new Fornecedor();
		f1.setCnpj("1222");

		fachada.removeFornecedor(f1.getCnpj());
	}

	/*
	 * --------------- TESTES -------Funcionario
	 * __________________________________________________________________
	 */

	private Funcionario criarFuncionarioPadraoUm() {

		func.setNome("Rodrigo");
		func.setCpf("111");
		func.setTelefone("111");
		func.setCidade("Sao Paulo");
		func.setBairro("Morumbi");
		func.setRua("Tricolor");
		func.setNumero(3);
		func.setCep("111");
		func.setContacorrente("123454");
		func.setAgencia("111");
		func.setBanco("Banco do Brasil");
		func.setId("111");

		return func;
	}

	private Funcionario criarFuncionarioPadraoDois() {

		func2.setNome("Carla");
		func2.setCep("112");
		func2.setTelefone("11122");
		func2.setCidade("Rio de Janeiro");
		func2.setBairro("Favela da Rocinha");
		func2.setRua("Flavio Batista");
		func2.setNumero(3);
		func2.setCep("111");
		func2.setContacorrente("123454");
		func2.setAgencia("121");
		func2.setBanco("Banco do Brasil");
		func2.setId("141");

		return func2;
	}

	@Test(expected = Exception.class)
	public void cadastrarFuncionario() {

		Funcionario funcionario1 = new Funcionario();
		funcionario1.setNome("Tigre");
		funcionario1.setCpf("12311");

		fachada.cadastrar(funcionario1);

		Assert.assertEquals(1, fachada.getgFunc().getFuncionarios().size());

	}

	@Test(expected = Exception.class)
	public void cadastrarMesmoFuncionario() {

		func = criarFuncionarioPadraoUm();
		fachada.cadastrar(func);
		fachada.cadastrar(func);
	}

	@Test(expected = Exception.class)
	public void pesquisaFuncionarioPorCpf() {

		func = criarFuncionarioPadraoUm();

		fachada.cadastrar(func);
		Funcionario func2 = fachada.pesquisaFuncionarioCpf(func.getCpf());

		Assert.assertEquals(func, func2);

	}

	@Test(expected = Exception.class)
	public void pesquisarCpfFuncionarioInexistente() {

		func = criarFuncionarioPadraoUm();
		fachada.cadastrar(func);
		fachada.pesquisaFuncionarioCpf("");

	}

	@Test(expected = Exception.class)
	public void pesquisaFuncionarioPorNome() {

		func = criarFuncionarioPadraoUm();

		fachada.cadastrar(func);
		fachada.pesquisaFuncionarioNome("Flavio");

		List<Funcionario> funcionarios = fachada.listarFuncionario();

		Funcionario funcionarioPesquisado = funcionarios.get(0);
		Assert.assertEquals(funcionarioPesquisado,
				fachada.pesquisaFuncionarioNome("Flavio"));

	}

	@Test(expected = Exception.class)
	public void alterarNomeFuncionario() {

		func = criarFuncionarioPadraoUm();
		fachada.cadastrar(func);

		func2 = criarFuncionarioPadraoDois();
		fachada.cadastrar(func2);

		func2 = fachada.editarFuncionario(func2);

		Assert.assertEquals("Flavio", f2.getNome());

	}

	@Test(expected = Exception.class)
	public void alterarCpfFuncionario() {

		func = criarFuncionarioPadraoUm();
		fachada.cadastrar(func);

		func2 = criarFuncionarioPadraoDois();
		fachada.cadastrar(func2);

		func2 = fachada.editarFuncionario(func);
		Assert.assertNotNull(func2.getCpf());
		Assert.assertEquals("111", func2.getCpf());
	}

	@Test(expected = Exception.class)
	public void addFuncionarioNomeNulo() {

		func = criarFuncionarioPadraoUm();
		func.setNome(null);
		fachada.cadastrar(func);
	}

	@Test(expected = Exception.class)
	public void addFuncionarioCpfNulo() {

		func = criarFuncionarioPadraoUm();
		func.setCpf(null);

		fachada.cadastrar(func);
	}

	@Test(expected = Exception.class)
	public void addFuncionarioCidadeNulo() {

		func = criarFuncionarioPadraoUm();
		func.setCidade(null);
		fachada.cadastrar(func);
	}

	@Test(expected = Exception.class)
	public void addFuncionarioRuaNulo() {

		func = criarFuncionarioPadraoUm();
		func.setRua(null);
		fachada.cadastrar(func);
	}

	@Test(expected = Exception.class)
	public void addFuncionarioBairroNulo() {

		func = criarFuncionarioPadraoUm();
		func.setBairro(null);
		fachada.cadastrar(func);
	}

	@Test(expected = Exception.class)
	public void addFuncionarioCepNulo() {

		func = criarFuncionarioPadraoUm();
		func.setCep(null);
		fachada.cadastrar(func);
	}

	@Test(expected = Exception.class)
	public void addFuncionarioEstadoNulo() {

		func = criarFuncionarioPadraoUm();
		func.setEstado(null);
		fachada.cadastrar(func);
	}

	@Test(expected = Exception.class)
	public void addFuncionarioEmailsNulo() {

		func = criarFuncionarioPadraoUm();
		func.setEmails(null);
		fachada.cadastrar(func);
	}

	@Test(expected = Exception.class)
	public void addFuncionarioId() {

		func = criarFuncionarioPadraoUm();
		func.setId(null);
		fachada.cadastrar(func);
	}

	@Test(expected = Exception.class)
	public void addFuncionarioBanco() {

		func = criarFuncionarioPadraoUm();
		func.setBanco(null);
		fachada.cadastrar(func);
	}

	@Test(expected = Exception.class)
	public void addFuncionarioAgencia() {

		func = criarFuncionarioPadraoUm();
		func.setAgencia(null);
		fachada.cadastrar(func);
	}

	@Test(expected = Exception.class)
	public void addFuncionarioContaCorrente() {

		func = criarFuncionarioPadraoUm();
		func.setContacorrente(null);
		fachada.cadastrar(func);
	}

	@Test(expected = Exception.class)
	public void addFuncionarioTelefone() {

		func = criarFuncionarioPadraoUm();
		func.setTelefone(null);
		fachada.cadastrar(func);
	}

	@Test(expected = Exception.class)
	public void removeFuncionario() {

		func = criarFuncionarioPadraoUm();

		fachada.cadastrar(func);
		fachada.removeFuncionario(func.getCpf());

	}

	@Test(expected = Exception.class)
	public void removerFuncionarioNaoExistente() {

		func = criarFuncionarioPadraoUm();
		Funcionario func1 = new Funcionario();
		func1.setCpf("112321");

		fachada.removeFuncionario(func1.getCpf());
	}

	/*
	 * --------------- TESTES -------Produto
	 * __________________________________________________________________
	 */

	private Produto criarProdutoPadraoUm() {

		p.setNome("Tijolo");
		p.setCodigo("555");
		p.setCategoria("A");
		p.setDataVenc("nao tem");
		p.setDataFab("2010");
		p.setFabricante("Amarelao");

		return p;
	}

	private Produto criarProdutoPadraoDois() {

		p2.setNome("Torneira");
		p2.setCodigo("700");
		p2.setCategoria("C");
		p2.setDataVenc("nao tem");
		p2.setDataFab("2012");
		p2.setFabricante("Amanco");

		return p;
	}

	@Test(expected = Exception.class)
	public void cadastrarProduto() {

		Produto produto = new Produto();
		produto.setNome("Cadeado");
		produto.setCodigo("2211");
		produto.setCategoria("E");

		fachada.cadastrar(produto);

		Assert.assertEquals(1, fachada.getgProduto().getProdutos().size());

	}

	@Test(expected = Exception.class)
	public void cadastrarMesmoProduto() {

		p = criarProdutoPadraoUm();
		fachada.cadastrar(p);
		fachada.cadastrar(p);
	}

	@Test(expected = Exception.class)
	public void pesquisaProdutoPorCodigo() {

		p = criarProdutoPadraoUm();

		fachada.cadastrar(p);
		Produto p2 = fachada.pesquisaProdutoCodigo(p.getCodigo());

		Assert.assertEquals(p, p2);

	}

	@Test(expected = Exception.class)
	public void pesquisarCodigoProdutoInexistente() {

		p = criarProdutoPadraoUm();
		fachada.cadastrar(p);
		fachada.pesquisaProdutoCodigo("");

	}

	@Test(expected = Exception.class)
	public void pesquisaProdutoPorNome() {

		p = criarProdutoPadraoUm();

		fachada.cadastrar(p);
		fachada.pesquisaProdutoNome("Tijolo");

		List<Produto> produtos = fachada.listarProduto();

		Produto produtoPesquisado = produtos.get(0);
		Assert.assertEquals(produtoPesquisado,
				fachada.pesquisaProdutoNome("Tijolo"));

	}

	@Test(expected = Exception.class)
	public void alterarNomeProduto() {

		p = criarProdutoPadraoUm();
		fachada.cadastrar(p);

		p2 = criarProdutoPadraoDois();
		fachada.cadastrar(p2);

		p2 = fachada.editarProduto(p2);

		Assert.assertEquals("Tijolo", f2.getNome());

	}

	@Test(expected = Exception.class)
	public void alterarCodigoProduto() {

		p = criarProdutoPadraoUm();
		fachada.cadastrar(p);

		p2 = criarProdutoPadraoDois();
		fachada.cadastrar(p2);

		p2 = fachada.editarProduto(p);
		Assert.assertNotNull(p2.getCodigo());
		Assert.assertEquals("555", p2.getCodigo());
	}

	@Test(expected = Exception.class)
	public void alterarCategoriaProduto() {

		p = criarProdutoPadraoUm();
		fachada.cadastrar(p);

		p2 = criarProdutoPadraoDois();
		fachada.cadastrar(p2);

		p2 = fachada.editarProduto(p);
		Assert.assertNotNull(p2.getCategoria());
		Assert.assertEquals("e", p2.getCategoria());
	}

	@Test(expected = Exception.class)
	public void addProdutoNomeNulo() {

		p = criarProdutoPadraoUm();
		p.setNome(null);
		fachada.cadastrar(p);
	}

	@Test(expected = Exception.class)
	public void addProdutoCategoriaNulo() {

		p = criarProdutoPadraoUm();
		p.setCategoria(null);

		fachada.cadastrar(p);
	}

	@Test(expected = Exception.class)
	public void addProdutoFabricanteNulo() {

		p = criarProdutoPadraoUm();
		p.setFabricante(null);
		fachada.cadastrar(p);
	}

	@Test(expected = Exception.class)
	public void addProdutoDataFabricacaoNulo() {

		p = criarProdutoPadraoUm();
		p.setDataFab(null);
		fachada.cadastrar(p);
	}

	@Test(expected = Exception.class)
	public void addProdutoDataVenciNulo() {

		p = criarProdutoPadraoUm();
		p.setDataVenc(null);
		fachada.cadastrar(p);
	}

	@Test(expected = Exception.class)
	public void removeProduto() {

		p = criarProdutoPadraoUm();

		fachada.cadastrar(p);
		fachada.removeProduto(p.getCodigo());

	}

	@Test(expected = Exception.class)
	public void removerProdutoNaoExistente() {

		p = criarProdutoPadraoUm();
		fachada.cadastrar(p);
		Produto p1 = new Produto();
		p1.setCodigo("112321");

		fachada.removeProduto(p1.getCodigo());
	}

}