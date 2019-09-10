package br.com.fileprocessor.config;


public enum RegistryType {

	SALESMAN_DATA("001", "Dados de Vendedores."),
    CLIENT_DATA("002", "Dados de Cliente"),   
    SALE_DATA("003", "Dados de Vendas.");
 	
    private String regTypeCode;
    private String regTypeDesc;   
    
    public String getRegTypeCode() {
		return regTypeCode;
	}
	public String getRegTypeDesc() {
		return regTypeDesc;
	}
	
	RegistryType(String regTypeCode, String regTypeDesc) {
    		this.regTypeCode = regTypeCode;
    		this.regTypeDesc = regTypeDesc;
    }
}
