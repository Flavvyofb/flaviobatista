package Excecao;

public class ExceptionGerenciadorFornecedor extends RuntimeException {
  
  private static final long serialVersionUID = 1L;

  
  public ExceptionGerenciadorFornecedor(String msg){
    super(msg);
  }

}