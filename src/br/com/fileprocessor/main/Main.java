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
				
		//2 - Lê pasta de leitura de arquivos e carrega registros em memória.		
			List<DataFileResponse>responseList = FileService.readDirFiles(DataType.IN_DATA);
		
		//3 - Realiza cálculos com os dados obtidos dos registros guardados em memória.		
			RegistryHelper.initDataResponseCalc(responseList);		
			
		//4 - Normaliza pasta de saída da arquivos.
			FileService.normalizeDirs(DataType.OUT_DATA);
		
		//5 - Cria arquivos no disco para persistência dos dados processados.
			FileService.writeFiles(DataType.OUT_DATA, responseList);
			
		//6 - Feedback ao usuário e finaliza execução do programa.
			FeedBackUtil.info();
		
		//7 - Fim do Programa	
		    System.exit(0);		
	}
}
