package Entidades;

public class Produto {
	
	public Produto(){
	    
	  }

		private String nome;
		private String categoria;
		private String fabricante;
		private String dataFab;
		private String dataVenc;
		private String codigo;
		private int qtdeEstoque;
		private int qtdeVendido;
		private int descontos;
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCategoria() {
			return categoria;
		}
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		public String getFabricante() {
			return fabricante;
		}
		public void setFabricante(String fabricante) {
			this.fabricante = fabricante;
		}
		public String getDataFab() {
			return dataFab;
		}
		public void setDataFab(String dataFab) {
			this.dataFab = dataFab;
		}
		public String getDataVenc() {
			return dataVenc;
		}
		public void setDataVenc(String dataVenc) {
			this.dataVenc = dataVenc;
		}
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public double getQtdeEstoque() {
			return qtdeEstoque;
		}
	
		public double getQtdeVendido() {
			return qtdeVendido;
		}
		
		public void setQtdeEstoque(int qtdeEstoque) {
			this.qtdeEstoque = qtdeEstoque;
		}
		public void setQtdeVendido(int qtdeVendido) {
			this.qtdeVendido = qtdeVendido;
		}
		public int getDescontos() {
			return descontos;
		}
		public void setDescontos(int descontos) {
			this.descontos = descontos;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((categoria == null) ? 0 : categoria.hashCode());
			result = prime * result
					+ ((codigo == null) ? 0 : codigo.hashCode());
			result = prime * result
					+ ((dataFab == null) ? 0 : dataFab.hashCode());
			result = prime * result
					+ ((dataVenc == null) ? 0 : dataVenc.hashCode());
			result = prime * result + descontos;
			result = prime * result
					+ ((fabricante == null) ? 0 : fabricante.hashCode());
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
			result = prime * result + qtdeEstoque;
			result = prime * result + qtdeVendido;
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
			Produto other = (Produto) obj;
			if (categoria == null) {
				if (other.categoria != null)
					return false;
			} else if (!categoria.equals(other.categoria))
				return false;
			if (codigo == null) {
				if (other.codigo != null)
					return false;
			} else if (!codigo.equals(other.codigo))
				return false;
			if (dataFab == null) {
				if (other.dataFab != null)
					return false;
			} else if (!dataFab.equals(other.dataFab))
				return false;
			if (dataVenc == null) {
				if (other.dataVenc != null)
					return false;
			} else if (!dataVenc.equals(other.dataVenc))
				return false;
			if (descontos != other.descontos)
				return false;
			if (fabricante == null) {
				if (other.fabricante != null)
					return false;
			} else if (!fabricante.equals(other.fabricante))
				return false;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			if (qtdeEstoque != other.qtdeEstoque)
				return false;
			if (qtdeVendido != other.qtdeVendido)
				return false;
			return true;
		}
			
		
		
}
