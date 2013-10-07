package Excecao;

@SuppressWarnings("serial")
public class ExceptionGerenciadorCliente extends RuntimeException {
   public ExceptionGerenciadorCliente(String msg){
    super(msg);
  }
}