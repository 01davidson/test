package br.com.fileprocessor.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import br.com.fileprocess.pojo.AbsRegistry;
import br.com.fileprocess.pojo.DataFileProcessedInfo;
import br.com.fileprocess.pojo.DataFileResponse;
import br.com.fileprocessor.config.DataType;
import br.com.fileprocessor.config.FileType;
import br.com.fileprocessor.config.PathValues;
import br.com.fileprocessor.helper.RegistryHelper;
import br.com.fileprocessor.util.SysUtil;

public class FileService {
	
	public static void normalizeDirs(DataType dataType) {	
				
		Path path = null;		
		// Verifica tipo de dados (entrada ou saída) e sistema operacional.
		if(dataType == DataType.IN_DATA) {			
			if(SysUtil.isWinOS()) {				
				path = Paths.get(PathValues.IN_DIR_NAME_WIN.getPathVal());				
			}else {
				path = Paths.get(PathValues.IN_DIR_NAME_UNIX.getPathVal());				
			}	
		}else if (dataType == DataType.OUT_DATA){			
			if(SysUtil.isWinOS()) {				
				path = Paths.get(PathValues.OUT_DIR_NAME_WIN.getPathVal());				
			}else {
				path = Paths.get(PathValues.OUT_DIR_NAME_UNIX.getPathVal());				
			}			
		}		
        try {
            Files.createDirectories(path);            
        } catch (IOException e) {        	       	
            e.printStackTrace();
        }		
	}
	
	//Inicializa processo de leitura
	public static List<DataFileResponse> readDirFiles(DataType dataType) {		
		List<DataFileResponse>dataFileResList = new ArrayList<>();
		DataFileResponse dataRes = null;
		String dirName = "";	
		if(dataType == DataType.IN_DATA) {	
			if(SysUtil.isWinOS()) {					
				dirName = PathValues.IN_DIR_NAME_WIN.getPathVal();
			}else {
				dirName = PathValues.IN_DIR_NAME_UNIX.getPathVal();			
			}	
			File file = new File(dirName); 
			File[] fileNames = file.listFiles(new FilenameFilter() {
			    public boolean accept(File dir, String name) {
			        return name.toLowerCase().endsWith(FileType.DAT.getFileTypeExt());
			    }
			});		
			// Lê arquivos no loop.
			for (File currentFile : fileNames) {								
				 dataRes = new DataFileResponse(
						 currentFile.getName(),
						 FileService.readFile(currentFile), 
						 new DataFileProcessedInfo());
				 dataFileResList.add(dataRes);
			}			
		}
		return dataFileResList;				
	}
	// Recebe arquivos individualmente para efetivar leitura
	public static List<AbsRegistry> readFile(File currentFile) {	   
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;
    List <AbsRegistry> registryList = null;
    String line = "";
	try {
		fileReader = new FileReader(currentFile.getAbsolutePath());
		bufferedReader = new BufferedReader(fileReader);
		registryList = new ArrayList<>();		
		
		while ((line = bufferedReader.readLine()) != null) {		         		    
		    String textSplit [] = line.split(";");		
		    //Gera objetos dos registros coletados.
		    registryList.add(RegistryHelper.generateRegistry(textSplit));   		         
		}
		    bufferedReader.close();		    
		 
	} catch (IOException e) {		 
		e.printStackTrace();
	}
	return registryList;	
	} 
	
	// Inicializa processo de escrita.
	public static void writeFiles(DataType dataType, List<DataFileResponse> dataRespList) {		
		String dirName = "";
		if(dataType == DataType.OUT_DATA) {			
			if(SysUtil.isWinOS()) {					
				dirName = PathValues.OUT_DIR_NAME_WIN.getPathVal();
			}else {
				dirName = PathValues.OUT_DIR_NAME_UNIX.getPathVal();			
			}	
		}	
		for(DataFileResponse dResp :dataRespList) {			
			try {				
			 FileWriter fW = null;
			 PrintWriter pW = null;			 
			 	// Cria arquivos dentro do loop.
				fW = new FileWriter(dirName + dResp.getSourceFileName() + FileType.DAT_PROC.getFileTypeExt());
				pW =  new PrintWriter(fW);
				// Escreve dados no respectivo arquivo após ser ajustado.
				pW.write(RegistryHelper.normalizeResponseInfo(dResp).toString());				
				pW.flush();				
				pW.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}			
	}
	
}
