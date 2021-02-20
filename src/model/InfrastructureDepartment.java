package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class InfrastructureDepartment {
	private static final String SAVE_PATH_FILE  ="src/data/contacts.ap";
	public final static String SPLIT ="\\|";
	private List<Billboard> billboards ; 
	
	public InfrastructureDepartment() throws ClassNotFoundException, IOException {
		setBillboards(new ArrayList<>());
		loadData();
		
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
	public void addBillboard(String Namecompany,String height,String  broad ,String browser) throws IOException {
		billboards.add(new Billboard(Namecompany, height,broad,browser));
		saveData();
	}
		
	
		public void importContacts(String fileName)throws IOException {
			 BufferedReader br = new BufferedReader(new FileReader(fileName));
			    String line = br.readLine();
			    while(line!=null){
			      String[] parts = line.split(SPLIT);
			      addBillboard(parts[3],parts[1],parts[0],parts[2]); 
			      line = br.readLine(); 
			    } 
			    br.close();
		}
		 public void exportData(String fileName) throws FileNotFoundException {
			 PrintWriter pw = new PrintWriter(fileName);
			 double danger = 1600;
			    for(int i=0;i<billboards.size();i++){
			    	if(billboards.get(i).calculateArea() >= danger ) {
			    	Billboard myContact = billboards.get(i);
			      pw.println(myContact.getNamecompany()+"|"+myContact.getHeight()+"|"+myContact.getWidth()+"|"+myContact.getBrowser());
			    	} 
			    }

			    pw.close();
			  }
			  
		 public void saveData() throws IOException{
			    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE));
			    oos.writeObject(billboards);
			    oos.close();
			  }
		 @SuppressWarnings("unchecked")
		public boolean loadData() throws IOException, ClassNotFoundException{
			    File f = new File(SAVE_PATH_FILE);
			    boolean loaded = false;
			    if(f.exists()){
			      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			      billboards = (List<Billboard>)ois.readObject();
			      ois.close();
			      loaded = true;
			    }
			    return loaded;
			  }
		
}
