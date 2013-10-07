package Entidades;

import java.util.Date;

public class Pessoa {

  public Pessoa(){
    
  }
  
  
private String cpf;
  public String getCpf() {
    return cpf;
  }
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  private String nome;
  private int codigo;
  private String rua;
  private int numero;
  private Date nascimento;
  private String cidade;
  private String telefone;
  private String estado;
  private String bairro;
  private String cep;
  private String emails;
  private String contatos;
  private String extras;
  
  public int getNumero() {
	    return numero;
	  }
	  public void setNumero(int numero) {
	    this.numero = numero;
	  }
	  public String getRua() {
	    return rua;
	  }

  
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public int getCodigo() {
    return codigo;
  }
  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }
  
  public void setRua(String rua) {
    this.rua = rua;
  }
  public Date getNascimento() {
    return nascimento;
  }
  public void setNascimento(Date nascimento) {
    this.nascimento = nascimento;
  }
  public String getCidade() {
    return cidade;
  }
  public void setCidade(String cidade) {
    this.cidade = cidade;
  }
  public String getTelefone() {
    return telefone;
  }
  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
  public String getEstado() {
    return estado;
  }
  public void setEstado(String estado) {
    this.estado = estado;
  }
  public String getBairro() {
    return bairro;
  }
  public void setBairro(String bairro) {
    this.bairro = bairro;
  }
  public String getCep() {
    return cep;
  }
  public void setCep(String cep) {
    this.cep = cep;
  }
  public String getEmails() {
    return emails;
  }
  public void setEmails(String emails) {
    this.emails = emails;
  }
  public String getContatos() {
    return contatos;
  }
  public void setContatos(String contatos) {
    this.contatos = contatos;
  }
  public String getExtras() {
    return extras;
  }
  public void setExtras(String extras) {
    this.extras = extras;
  }
  
  @Override
  public int hashCode() {
  	final int prime = 31;
  	int result = 1;
  	result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
  	result = prime * result + ((cep == null) ? 0 : cep.hashCode());
  	result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
  	result = prime * result + codigo;
  	result = prime * result + ((contatos == null) ? 0 : contatos.hashCode());
  	result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
  	result = prime * result + ((emails == null) ? 0 : emails.hashCode());
  	result = prime * result + ((estado == null) ? 0 : estado.hashCode());
  	result = prime * result + ((extras == null) ? 0 : extras.hashCode());
  	result = prime * result
  			+ ((nascimento == null) ? 0 : nascimento.hashCode());
  	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
  	result = prime * result + numero;
  	result = prime * result + ((rua == null) ? 0 : rua.hashCode());
  	result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
  	return result;
  }
  @Override
  public boolean equals(Object obj) {
  	if (this == obj)
  		return true;
  	if (obj == null)
  		return false;
  	if (getClass() != obj.getClass())
  		return false;
  	Pessoa other = (Pessoa) obj;
  	if (bairro == null) {
  		if (other.bairro != null)
  			return false;
  	} else if (!bairro.equals(other.bairro))
  		return false;
  	if (cep == null) {
  		if (other.cep != null)
  			return false;
  	} else if (!cep.equals(other.cep))
  		return false;
  	if (cidade == null) {
  		if (other.cidade != null)
  			return false;
  	} else if (!cidade.equals(other.cidade))
  		return false;
  	if (codigo != other.codigo)
  		return false;
  	if (contatos == null) {
  		if (other.contatos != null)
  			return false;
  	} else if (!contatos.equals(other.contatos))
  		return false;
  	if (cpf == null) {
  		if (other.cpf != null)
  			return false;
  	} else if (!cpf.equals(other.cpf))
  		return false;
  	if (emails == null) {
  		if (other.emails != null)
  			return false;
  	} else if (!emails.equals(other.emails))
  		return false;
  	if (estado == null) {
  		if (other.estado != null)
  			return false;
  	} else if (!estado.equals(other.estado))
  		return false;
  	if (extras == null) {
  		if (other.extras != null)
  			return false;
  	} else if (!extras.equals(other.extras))
  		return false;
  	if (nascimento == null) {
  		if (other.nascimento != null)
  			return false;
  	} else if (!nascimento.equals(other.nascimento))
  		return false;
  	if (nome == null) {
  		if (other.nome != null)
  			return false;
  	} else if (!nome.equals(other.nome))
  		return false;
  	if (numero != other.numero)
  		return false;
  	if (rua == null) {
  		if (other.rua != null)
  			return false;
  	} else if (!rua.equals(other.rua))
  		return false;
  	if (telefone == null) {
  		if (other.telefone != null)
  			return false;
  	} else if (!telefone.equals(other.telefone))
  		return false;
  	return true;
  }

  

}