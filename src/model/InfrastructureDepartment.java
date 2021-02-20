package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InfrastructureDepartment {
	private static final String SAVE_PATH_FILE  ="data/billboards.ap2";
	public final static String SPLIT ="\\|";
	private List<Billboard> billboards ; 
	public InfrastructureDepartment() {
		setBillboards(new ArrayList<>());
		
	}
	public List<Billboard> getBillboards() {
		return billboards;
	}
	public void setBillboards(List<Billboard> billboards) {
		this.billboards = billboards;
	}
	public static String getSavePathFile() {
		return SAVE_PATH_FILE;
	}
	public void addBillboard(String Namecompany,String height,String  broad ,String browser) {
		billboards.add(new Billboard(Namecompany, height,broad,browser));
	}
		public void importData(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String read = br.readLine();
		while(read!=null) {
			String[]position = read.split(SPLIT);
			String found= "false";
			if(position[2].equals("true")) {
				found = "true";
			}
			if(!position[0].equals("width")) {
				addBillboard(position[0],position[1],found,position[3]);
			}
			read = br.readLine();
		}
		br.close();
	}
		public void importContacts(String fileName)throws IOException {
			 BufferedReader br = new BufferedReader(new FileReader(fileName));
			    String line = br.readLine();
			    while(line!=null){
			      String[] parts = line.split(";");
			      addBillboard(parts[0],parts[1],parts[2],parts[3]);
			      line = br.readLine();
			    }
			    br.close();
		}
}
