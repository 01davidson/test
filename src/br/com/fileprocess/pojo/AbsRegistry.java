package br.com.fileprocess.pojo;

public abstract class AbsRegistry {
 
private String code;

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

@Override
public String toString() {
	return "AbsRegistry [code=" + code + "]";
}
 
}
