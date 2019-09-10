package br.com.fileprocessor.util;

public class SysUtil {

	public static boolean isWinOS() {		
		String OS = System.getProperty("os.name").toLowerCase();		 		 
		return OS.contains("win");
	}
}
