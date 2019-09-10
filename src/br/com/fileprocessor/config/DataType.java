package br.com.fileprocessor.config;

public enum DataType {

    IN_DATA("IN", "Dados de entrada."),
    OUT_DATA("OUT", "Dados de saída.");
 	
    public String dataTypeVal;
    public String dataTypeDesc;
    
    DataType(String dataTypeVal, String dataTypeDesc) {
    		this.dataTypeVal = dataTypeVal;
    		this.dataTypeDesc = dataTypeDesc;
    	}
}
