package Entidades;

public class Funcionario extends Pessoa {
  
  public Funcionario(){
    
  }

    private String id;
    public String getId() {
      return id;
    }
    public void setId(String id) {
      this.id = id;
    }

    private String banco;
    private String agencia;
    private String contacorrente;
    private int salario;
    
    public String getBanco() {
      return banco;
    }
    public void setBanco(String banco) {
      this.banco = banco;
    }
    public String getAgencia() {
      return agencia;
    }
    public void setAgencia(String agencia) {
      this.agencia = agencia;
    }
   
    public String getContacorrente() {
		return contacorrente;
	}
	public void setContacorrente(String contacorrente) {
		this.contacorrente = contacorrente;
	}
	public int getSalario() {
      return salario;
    }
    public void setSalario(int salario) {
      this.salario = salario;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + ((banco == null) ? 0 : banco.hashCode());
		result = prime * result
				+ ((contacorrente == null) ? 0 : contacorrente.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + salario;
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
		Funcionario other = (Funcionario) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (banco == null) {
			if (other.banco != null)
				return false;
		} else if (!banco.equals(other.banco))
			return false;
		if (contacorrente == null) {
			if (other.contacorrente != null)
				return false;
		} else if (!contacorrente.equals(other.contacorrente))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (salario != other.salario)
			return false;
		return true;
	}
	
    
}