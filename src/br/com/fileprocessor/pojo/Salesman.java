package br.com.fileprocessor.pojo;

import java.math.BigDecimal;

import br.com.fileprocessor.config.RegistryType;

public class Salesman extends AbsRegistry{

	private String cpf;
	private String name;
	private BigDecimal salary;	
	
	public  Salesman(){}
	public Salesman(String cpf, String name, BigDecimal salary) {	
		super();
		this.setCode(RegistryType.SALESMAN_DATA.getRegTypeCode());
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
	}

	public String getCode() {
		return super.getCode();
	}	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Salesman [code=" + super.getCode() + ", cpf=" + cpf + ", name=" + name + ", salary=" + salary + "]";
	} 
}
