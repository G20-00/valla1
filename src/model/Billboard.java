package model;

import java.io.Serializable;

public class Billboard implements Serializable{
	
	private static final long serialVersionUID = 1;
	private String Namecompany;
	private String height;
	private String width;
	private String browser;
	public Billboard(String na,String he,String broa,String brow ) {
		setNamecompany(na);
		setHeight(he);
		setWidth(broa); 
		setBrowser(brow); 
	}
	public String getNamecompany() {
		return Namecompany;
	}
	public void setNamecompany(String namecompany) {
		Namecompany = namecompany;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	
	public double calculateArea() {
		double num = 0 ;
		double dou =Double.parseDouble(height);
		double dou2 =Double.parseDouble(width);
		num = dou* dou2;
		return num;
	}
}
