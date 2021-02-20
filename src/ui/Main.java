package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.InfrastructureDepartment;

public class Main extends Application{
		private InfrastructureDepartment infrastructure;
		private InfrastructureDepartmentGUI infrastructureGui;
		
		
		public Main() {
			try {
				infrastructure = new InfrastructureDepartment();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Alert alert = new Alert(AlertType.INFORMATION);
			    alert.setTitle("Contact Manager");  
		    alert.setContentText("Error loading data from file");
			
			    alert.showAndWait();
			}
			infrastructureGui = new InfrastructureDepartmentGUI(infrastructure);
			
		}
		
		public static void main(String[] args) {
			launch(args);
			
		}

		@Override
		public void start(Stage primaryStage) throws Exception {
			FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("White.fxml"));
			fxmlLoader1.setController(infrastructureGui);
			Parent root2= fxmlLoader1.load();
			Scene scene=  new Scene (root2);
			primaryStage.setScene(scene);
			primaryStage.setTitle("BillBoard");
			primaryStage.show();//para mostrar
			infrastructureGui.inicializedMain();
		}

		public InfrastructureDepartment getInfrastructure() {
			return infrastructure;
		}

		public void setInfrastructure(InfrastructureDepartment infrastructure) {
			this.infrastructure = infrastructure;
		}

		

	}