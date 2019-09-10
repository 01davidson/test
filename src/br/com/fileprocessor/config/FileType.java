package br.com.fileprocessor.config;



public enum FileType {

    DAT(".dat", "Arquivo de entrada."),
    DAT_PROC(".proc", "Arquivo de saída.");
 	
    private String fileTypeExt;
    private String fileTypeDesc;
    
    FileType(String fileTypeExt, String fileTypeDesc) {
    		this.fileTypeExt = fileTypeExt;
    		this.fileTypeDesc = fileTypeDesc;
    	}

	public String getFileTypeExt() {
		return fileTypeExt;
	}

	public String getFileTypeDesc() {
		return fileTypeDesc;
	}    
    
}