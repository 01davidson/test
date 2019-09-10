package br.com.fileprocessor.config;

public enum DataResponseFields {

	 CLIENT_COUNT_FIELD(1, "Quantidade de Clientes: "),
	 SALESMAN_COUNT_FIELD(2, "Quantidade de Vendedores: "),
	 HIGHER_SALE_FIELD(3, "ID da Venda de valor mais alto: "),
	 SALESMAN_NAME_FIELD(4, "Nome do Vendedor que menos vendeu: ");
	 	
	    private int dataFieldLine;
	    private String dataFieldDesc;
	    	    
	     public int getDataFieldLine() {
			return dataFieldLine;
		}
		public String getDataFieldDesc() {
			return dataFieldDesc;
		}
		DataResponseFields(int dataFieldLine, String dataFieldDesc) {
	    		this.dataFieldLine = dataFieldLine;
	    		this.dataFieldDesc = dataFieldDesc;
	    	}
	}