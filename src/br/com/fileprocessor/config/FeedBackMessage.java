package br.com.fileprocessor.config;

public enum FeedBackMessage {

    END_PROCESS("Processamento Concluído", "Info.");     
 	
    private String message;
    private String messageType;
    
    FeedBackMessage(String message, String messageType) {
    		this.message = message;
    		this.messageType = messageType;
    	}

	public String getMessage() {
		return message;
	}
	public String getMessageType() {
		return messageType;
	}    
}
