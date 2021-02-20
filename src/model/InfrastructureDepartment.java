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
	public void importData(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String read = br.readLine();
		while(read!=null) {
			String[]position = read.split(SPLIT);
			boolean found= false;
			if(position[2].equals("true")) {
				found = true;
			}
			if(!position[0].equals("width")) {
				
			}
			read = br.readLine();
		}
		br.close();
	}
}
