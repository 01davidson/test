package br.com.fileprocessor.pojo;

public class DataFileProcessedInfo {

	private int clientCount;
	private int salesmanCount;
	private String 	idHighestSaleVal;
	private String leastSoldSellerName;	
	
	public DataFileProcessedInfo() {}
	public DataFileProcessedInfo(int clientCount, int salesmanCount, String idHighestSaleVal, String leastSoldSellerName) {
		super();
		this.clientCount = clientCount;
		this.salesmanCount = salesmanCount;
		this.idHighestSaleVal = idHighestSaleVal;
		this.leastSoldSellerName = leastSoldSellerName;
	}	
	public int getClientCount() {
		return clientCount;
	}
	public void setClientCount(int clientCount) {
		this.clientCount = clientCount;
	}
	public int getSalesmanCount() {
		return salesmanCount;
	}
	public void setSalesmanCount(int salesmanCount) {
		this.salesmanCount = salesmanCount;
	}
	public String getIdHighestSaleVal() {
		return idHighestSaleVal;
	}
	public void setIdHighestSaleVal(String idHighestSaleVal) {
		this.idHighestSaleVal = idHighestSaleVal;
	}
	public String getLeastSoldSellerName() {
		return leastSoldSellerName;
	}
	public void setLeastSoldSellerName(String leastSoldSellerName) {
		this.leastSoldSellerName = leastSoldSellerName;
	}

	@Override
	public String toString() {
		return "DataFileProcessedInfo [clientCount=" + clientCount + ", salesmanCount=" + salesmanCount
				+ ", idHighestSaleVal=" + idHighestSaleVal + ", leastSoldSellerName=" + leastSoldSellerName + "]";
	}			
	
}
