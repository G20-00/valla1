package ui;

import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import model.Billboard;

import model.InfrastructureDepartment;

public class InfrastructureDepartmentGUI {
	 @FXML
	    private TableView<Billboard> tvContactList;
	 @FXML
	    private TableColumn<Billboard, String> width;

	    @FXML
	    private TableColumn<Billboard, String> height;

	    @FXML
	    private TableColumn<Billboard, String> inUse;

	    @FXML
	    private TableColumn<Billboard, String> nameCompany;
	 @FXML
	    private TextField txtName;

	    @FXML
	    private TextField txtheight;
	    @FXML
	    private ComboBox<String> browserBox;
	    @FXML
	    private TextField txtbroad;

	private  InfrastructureDepartment infrastructure ;
	
	public InfrastructureDepartmentGUI(InfrastructureDepartment infrastructure) {
		this.setInfrastructure(infrastructure);	}
	public void initializeTableView() {
		ObservableList<Billboard> observableList;
    	observableList = FXCollections.observableArrayList(infrastructure.getBillboards());
    	
		tvContactList.setItems(observableList);
		width.setCellValueFactory(new PropertyValueFactory<Billboard,String>("broad")); 
		height.setCellValueFactory(new PropertyValueFactory<Billboard,String>("height")); 
		inUse.setCellValueFactory(new PropertyValueFactory<Billboard,String>("browser")); 
		nameCompany.setCellValueFactory(new PropertyValueFactory<Billboard,String>("Namecompany")); 
	}
    @FXML
    private BorderPane white;
	
	    public void inicializedMain() throws IOException {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
			fxmlLoader.setController(this);    	
			Parent addBillboard = fxmlLoader.load();
	    	white.getChildren().clear();
	    	white.setTop(addBillboard);
	    }
		public InfrastructureDepartment getInfrastructure() {
			return infrastructure;
		}
		public void setInfrastructure(InfrastructureDepartment infrastructure) {
			this.infrastructure = infrastructure;
		}
		 @FXML
		   public void AddBillboards(ActionEvent event) throws IOException {
			 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Register.fxml"));
				
				fxmlLoader.setController(this);    	
				Parent addBillboard = fxmlLoader.load();
				browserBox.getItems().addAll("Si","No");
				white.getChildren().clear();
				white.setTop(addBillboard);
		    }
		   @FXML
		    void cancel(ActionEvent event) throws IOException {
			   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
				fxmlLoader.setController(this);    	
				Parent addBillboard = fxmlLoader.load();
		    	white.getChildren().clear();
		    	white.setTop(addBillboard);
		    }

		    @FXML
		    void save(ActionEvent event)throws IOException {
		    	
				String Namecompany = txtName.getText();
		        String height = txtheight.getText();
		        String broad = txtbroad.getText();
		        String browser = " ";
		        browser	= browserBox.getValue().toString();
		        if((Namecompany!= "")&& (height!="" )&& (browser!="")&& (broad!="") ) {
		        	
		        	infrastructure.addBillboard(Namecompany, height, broad ,browser); 
		    		
		    		//Namecompany.setText("");
		    		//height.setText("");
		    		//broad.setText("");
		    		Alert alert = new Alert(AlertType.INFORMATION);
		    		alert.setTitle("Information Dialog");
		    		alert.setHeaderText(null);
		    		alert.setContentText("Your account has been successfully created");

		    		alert.showAndWait();
		    	}else {
		    		Alert alert = new Alert(AlertType.INFORMATION);
		    		alert.setTitle("Information Dialog");
		    		alert.setHeaderText(null);
		    		alert.setContentText("Your account wasnt successfully created");
		    	}
		    }
		    @FXML
		    void DisplayBillboards(ActionEvent event) throws IOException {
		    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BillboardList.fxml"));
				
				fxmlLoader.setController(this);
				Parent contactListPane = fxmlLoader.load();
		    	
				white.getChildren().clear();
		    	white.setCenter(contactListPane);
		    	initializeTableView();
		    }

		    @FXML
		    void ExportReport(ActionEvent event) {

		    }

		    @FXML
		    void ImportBillboards(ActionEvent event) {
		    	FileChooser fileChooser = new FileChooser();
		    	fileChooser.setTitle("Open Resource File");
		    	File f = fileChooser.showOpenDialog(white.getScene().getWindow());
		    	if(f!=null) {
		    		Alert alert = new Alert(AlertType.INFORMATION);
				    alert.setTitle("Import Contacts");
		    		try {
		    			infrastructure.importContacts(f.getAbsolutePath());   
					    alert.setContentText("The contact data was imported succesfully");
					
					    alert.showAndWait();
					} catch (IOException e) {
						  alert.setContentText("The contact data was not imported. An error ocurred.");
						    alert.showAndWait();
					
					}
		    	}
		    }

		    @FXML
		    void leave(ActionEvent event) {

		    }	
		    @FXML
		    public void showAbout(ActionEvent event) {
			    Alert alert = new Alert(AlertType.INFORMATION);
			    alert.setTitle("Billboard");
			    alert.setHeaderText("Credits");
			    alert.setContentText("Gianni Benavides\nAlgorithms II");
			
			    alert.showAndWait();
		    }

}
