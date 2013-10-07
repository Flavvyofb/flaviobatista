package Entidades;

public class Cliente extends Pessoa {
  
  public Cliente(){
    
  }

  private String cpf;
  private String categoria;
 
  public String getCategoria() {
    return categoria;
  }
  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  private int cartaoFidelidade;
  public String getCpf() {
    return cpf;
  }
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  public int getCartaoFidelidade() {
    return cartaoFidelidade;
  }
  public void setCartaoFidelidade(int cartaoFidelidade) {
    this.cartaoFidelidade = cartaoFidelidade;
    
  }
@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + cartaoFidelidade;
	result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
	result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cliente other = (Cliente) obj;
	if (cartaoFidelidade != other.cartaoFidelidade)
		return false;
	if (categoria == null) {
		if (other.categoria != null)
			return false;
	} else if (!categoria.equals(other.categoria))
		return false;
	if (cpf == null) {
		if (other.cpf != null)
			return false;
	} else if (!cpf.equals(other.cpf))
		return false;
	return true;
}
  
  
  
}
