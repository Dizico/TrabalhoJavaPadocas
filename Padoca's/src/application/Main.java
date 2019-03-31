package application;
//Adriano  082160002
//João     082160015	
//Leonardo 082160001
//Rodrigo  082160006

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
 
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
    	
        try {

        	Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
 
            primaryStage.setTitle("Padoca's");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
         
        } catch(Exception e) {
        	
            e.printStackTrace();
            
        }
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}