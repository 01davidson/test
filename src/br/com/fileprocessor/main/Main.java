package br.com.fileprocessor.main;

import java.util.List;

import br.com.fileprocessor.pojo.DataFileResponse;
import br.com.fileprocessor.config.DataType;
import br.com.fileprocessor.helper.RegistryHelper;
import br.com.fileprocessor.service.FileService;
import br.com.fileprocessor.util.FeedBackUtil;

public class Main {
	
	public static void main (String args[]) {
		
		//1 - Normaliza pasta de leitura de arquivos.
			FileService.normalizeDirs(DataType.IN_DATA);
				
		//2 - L� pasta de leitura de arquivos e carrega registros em mem�ria.		
			List<DataFileResponse>responseList = FileService.readDirFiles(DataType.IN_DATA);
		
		//3 - Realiza c�lculos com os dados obtidos dos registros guardados em mem�ria.		
			RegistryHelper.initDataResponseCalc(responseList);		
			
		//4 - Normaliza pasta de sa�da da arquivos.
			FileService.normalizeDirs(DataType.OUT_DATA);
		
		//5 - Cria arquivos no disco para persist�ncia dos dados processados.
			FileService.writeFiles(DataType.OUT_DATA, responseList);
			
		//6 - Feedback ao usu�rio e finaliza execu��o do programa.
			FeedBackUtil.info();
		
		//7 - Fim do Programa	
		    System.exit(0);		
	}
}
