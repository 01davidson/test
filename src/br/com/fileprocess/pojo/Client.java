package br.com.fileprocess.pojo;

import br.com.fileprocessor.config.RegistryType;

public class Client extends AbsRegistry {

	private String cnpj;
	private String name;
	private String activityArea;
	
	public Client (String cnpj, String name, String activityArea) {
		super();
		this.setCode(RegistryType.CLIENT_DATA.getRegTypeCode());
		this.cnpj = cnpj;
		this.name = name;
		this.activityArea = activityArea;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActivityArea() {
		return activityArea;
	}

	public void setActivityArea(String activityArea) {
		this.activityArea = activityArea;
	}

	public String getCode() {
		return super.getCode();
	}

	@Override
	public String toString() {
		return "Client [code=" + super.getCode() + ", cnpj=" + cnpj + ", name=" + name + ", activityArea=" + activityArea + "]";
	}	
}
