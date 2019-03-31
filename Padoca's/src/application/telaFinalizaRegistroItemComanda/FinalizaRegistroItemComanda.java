package application.telaFinalizaRegistroItemComanda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FinalizaRegistroItemComanda extends Application {

	public void start(Stage primaryStage) {
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("Visual_FinalizaRegistroItemComanda.fxml"));

			Scene scene = new Scene(root, 800, 600);

			scene.setOnKeyPressed(e -> System.out.println(e.getCode()));
			
			primaryStage.setTitle("Finalização de registro de itens na comanda");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		} //try
		
	}//start
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	} //main

}
