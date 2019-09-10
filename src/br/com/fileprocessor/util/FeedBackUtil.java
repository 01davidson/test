package br.com.fileprocessor.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.fileprocessor.config.FeedBackMessage;

public class FeedBackUtil {

	public static void info() {
		 
	    JFrame frame = new JFrame(
	    		FeedBackMessage.END_PROCESS.getMessageType());	    
	    JOptionPane.showMessageDialog(frame,
	    	FeedBackMessage.END_PROCESS.getMessage(),  
	    	FeedBackMessage.END_PROCESS.getMessageType(), // titulo da janela 
	        JOptionPane.INFORMATION_MESSAGE);
	}
}
