package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.InfrastructureDepartment;

public class InfrastructureDepartmentGUI {
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
		    void cancel(ActionEvent event) {

		    }

		    @FXML
		    void save(ActionEvent event) {

		    }
		    @FXML
		    void DisplayBillboards(ActionEvent event) {

		    }

		    @FXML
		    void ExportReport(ActionEvent event) {

		    }

		    @FXML
		    void ImportBillboards(ActionEvent event) {

		    }

		    @FXML
		    void leave(ActionEvent event) {

		    }	
}
