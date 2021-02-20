package model;

public class Billboard {
	private String Namecompany;
	private String height;
	private String broad;
	private String browser;
	public Billboard(String na,String he,String broa,String brow ) {
		setNamecompany(na);
		setHeight(he);
		setBroad(broa);
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
	public String getBroad() {
		return broad;
	}
	public void setBroad(String broad) {
		this.broad = broad;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	

}
