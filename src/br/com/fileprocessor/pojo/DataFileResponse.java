package br.com.fileprocessor.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DataFileResponse {

	private String sourceFileName;
	private List<AbsRegistry>fileRegistryList;	
	private DataFileProcessedInfo processedInfo;
	
	public List<AbsRegistry> getFileRegistryList() {
		return fileRegistryList;
	}
	public void setFileRegistryList(List<AbsRegistry> fileRegistryList) {
		this.fileRegistryList = fileRegistryList;
	}
	public DataFileProcessedInfo getProcessedInfo() {
		return processedInfo;
	}
	public void setProcessedInfo(DataFileProcessedInfo processedInfo) {
		this.processedInfo = processedInfo;
	}
	public String getSourceFileName() {
		return sourceFileName;
	}
	public void setSourceFileName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}
	public DataFileResponse(String sourceFileName, List<AbsRegistry> fileRegistryList,
			DataFileProcessedInfo processedInfo) {
		super();
		this.sourceFileName = sourceFileName;
		this.fileRegistryList = fileRegistryList;
		this.processedInfo = processedInfo;
	}
	//Itera sobre os objetos realizando os cálculos,
	//adicionando os resultados em objeto do tipo DataFileProcessedInfo
	public  void calc() {
		
		Map<String, Integer> salesmanMap = new HashMap<>();		 
		Sale sale = new Sale();
		BigDecimal baseValue = new BigDecimal(0);
		String idSaleMaxValue = ""; 
		
		for(AbsRegistry absReg : this.fileRegistryList) {			
			// SE  registro de 
			if(absReg instanceof Client ) {				
				this.processedInfo.setClientCount(
					this.processedInfo.getClientCount()+1);				
			}
			// SE registro de Vendedor
			if(absReg instanceof Salesman ) {				
				this.processedInfo.setSalesmanCount(
						this.processedInfo.getSalesmanCount()+1);									
			}
			// SE registro de Venda
			if(absReg instanceof Sale) {	
				sale = (Sale)absReg;				
				BigDecimal itemCount = new BigDecimal(sale.getItemCount());
				BigDecimal currSaleValue = itemCount.multiply(sale.getItemPrice());				
				if( currSaleValue.compareTo(baseValue) >=1) {
					baseValue = currSaleValue;
					idSaleMaxValue = sale.getIdSale();					
				}				
				if (!salesmanMap.containsKey(sale.getSalesmanName()))
					salesmanMap.put(sale.getSalesmanName(), 0);
				salesmanMap.put(sale.getSalesmanName(), salesmanMap.get(sale.getSalesmanName()) + 1);
			}	 			
			this.processedInfo.setIdHighestSaleVal(idSaleMaxValue);			
			}
		
		//OBS.: -> "Nome do Vendedor que menos vendeu:" 
		// Deseja-se saber o número de registro de vendas por vendedor ou valor
		// de vendas-quantidade de itens ?
		Entry<String, Integer> min = null;
		for (Entry<String, Integer> entry : salesmanMap.entrySet()) {
		    if (min == null || min.getValue() > entry.getValue()) {
		        min = entry;
		    }
		}
		 this.processedInfo.setLeastSoldSellerName(min.getKey()); 			
		}
	@Override
	public String toString() {
		return "DataFileResponse [sourceFileName=" + sourceFileName + ", fileRegistryList=" + fileRegistryList
				+ ", processedInfo=" + processedInfo + "]";
	} 		
}
