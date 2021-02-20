package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.InfrastructureDepartment;

public class Main extends Application{
		private InfrastructureDepartment infrastructure;
		private InfrastructureDepartmentGUI infrastructureGui;
		
		
		public Main(){
			infrastructure = new InfrastructureDepartment();
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