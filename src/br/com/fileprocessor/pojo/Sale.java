package br.com.fileprocessor.pojo;

import java.math.BigDecimal;

import br.com.fileprocessor.config.RegistryType;

public class Sale extends AbsRegistry{
 
	private String idSale;
	private String idItem;
	private String itemCount;
	private BigDecimal itemPrice;
	private String salesmanName;
	
		 public Sale(String idSale, String idItem, String itemCount, BigDecimal itemPrice,
			String salesmanName) {
		super();
		this.setCode(RegistryType.SALE_DATA.getRegTypeCode());
		this.idSale = idSale;
		this.idItem = idItem;
		this.itemCount = itemCount;
		this.itemPrice = itemPrice;
		this.salesmanName = salesmanName;
		
	}
	public Sale() {}
	
	public String getCode() {
		return super.getCode();
	}
	public String getIdSale() {
		return idSale;
	}
	public void setIdSale(String idSale) {
		this.idSale = idSale;
	}
	public String getIdItem() {
		return idItem;
	}
	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}
	public String getItemCount() {
		return itemCount;
	}
	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}
	public BigDecimal getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getSalesmanName() {
		return salesmanName;
	}
	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}
	@Override
	public String toString() {
		return "Sale [code=" + super.getCode() + ", idSale=" + idSale + ", idItem=" + idItem + ", itemCount=" + itemCount
				+ ", itemPrice=" + itemPrice + ", salesmanName=" + salesmanName + "]";
	}
}
