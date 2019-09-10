package br.com.fileprocessor.config;

public enum PathValues{
	
    IN_DIR_NAME_WIN("\\dados\\in", "Nome do diretório de entrada de dados - WINDOWS O.S."),
    IN_DIR_NAME_UNIX("/dados/in",  "Nome do diretório de entrada de dados - 'UNIX LIKE' O.S."),
    OUT_DIR_NAME_WIN("\\dados\\out\\", "Nome do diretório de saída de dados - WINDOWS O.S."),
    OUT_DIR_NAME_UNIX("/dados/out/", "Nome do diretório de saída de dados - 'UNIX LIKE' O.S.");
 	
    private String pathVal;
    private String pathDesc;
    
    	PathValues(String pathVal, String pathDesc) {
    		this.pathVal = pathVal;
    		this.pathDesc = pathDesc;
    	}
		public String getPathVal() {
			return pathVal;
		}
		public String getPathDesc() {
			return pathDesc;
		} 
}