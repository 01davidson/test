package br.com.fileprocessor.helper;

import java.math.BigDecimal;
import java.util.List;

import br.com.fileprocess.pojo.AbsRegistry;
import br.com.fileprocess.pojo.Client;
import br.com.fileprocess.pojo.DataFileResponse;
import br.com.fileprocess.pojo.Sale;
import br.com.fileprocess.pojo.Salesman;
import br.com.fileprocessor.config.DataResponseFields;
import br.com.fileprocessor.config.RegistryType;

public class RegistryHelper {
	// Gera objetos dos respectivos registros.
	public static AbsRegistry generateRegistry(String data[]) {
		
		if(data!= null && 
				(!data[0].isEmpty() && !data[0].equals(""))){
		
			if(data[0].equals(RegistryType.CLIENT_DATA.getRegTypeCode())) {			
				Client cli = new Client(
						data[1].trim(), 
						data[2].trim(),
						data[3].trim()
						);
				return cli;
				
			}else if(data[0].equals(RegistryType.SALE_DATA.getRegTypeCode())){
				Sale sale = new Sale(
						data[1].trim(), 
						data[2].trim(), 
						data[3].trim(), 
						new BigDecimal(data[4]), 
						data[5].trim()
						);
				return sale;
				
			}else if(data[0].equals(RegistryType.SALESMAN_DATA.getRegTypeCode())){
				Salesman salesman = new Salesman(
						data[1].trim(), 
						data[2].trim(), 
						new BigDecimal(data[3])
						);		
				return salesman; 
			}
		}
		return null;
	}
	// Inicializa cálculo das informações.
	public static void initDataResponseCalc(List <DataFileResponse>dataResList) {		
		for(DataFileResponse dFR: dataResList) {		
			dFR.calc();			 		
		} 		
	}
	// Organiza a escrita das informações dos registros nos arquivos.
	public static StringBuilder normalizeResponseInfo(DataFileResponse dataFileResp) {		
		StringBuilder sT = new StringBuilder();
		sT.append(
				DataResponseFields.CLIENT_COUNT_FIELD.getDataFieldLine() + "] " +
				DataResponseFields.CLIENT_COUNT_FIELD.getDataFieldDesc() +
				dataFileResp.getProcessedInfo().getClientCount()  + " , \r\n");
					
		sT.append(
				DataResponseFields.SALESMAN_COUNT_FIELD.getDataFieldLine() + "] " +
				DataResponseFields.SALESMAN_COUNT_FIELD.getDataFieldDesc() + 
				dataFileResp.getProcessedInfo().getSalesmanCount() + " , \r\n");
		
		sT.append(
				DataResponseFields.HIGHER_SALE_FIELD.getDataFieldLine() + "] " +
				DataResponseFields.HIGHER_SALE_FIELD.getDataFieldDesc() + 
				dataFileResp.getProcessedInfo().getIdHighestSaleVal()  + " , \r\n");
		
		sT.append(
				DataResponseFields.SALESMAN_NAME_FIELD.getDataFieldLine() + "] " +
				DataResponseFields.SALESMAN_NAME_FIELD.getDataFieldDesc() + 
				dataFileResp.getProcessedInfo().getLeastSoldSellerName()+ " .\r\n"
		);		
		 return sT;
	}	
}
