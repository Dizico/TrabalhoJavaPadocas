package application;
//Adriano  082160002
//Jo�o     082160015	
//Leonardo 082160001
//Rodrigo  082160006

import java.sql.SQLException;

import application.data.dao.FuncionarioDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
    {
        @Override
        public void start (Stage primaryStage){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../resources/views/Main.fxml"));
            primaryStage.setTitle("Padoca's");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException, ClassNotFoundException {
        FuncionarioDao base = new FuncionarioDao();
        launch(args);
//        System.out.println(base.delete(new FuncionarioEntity()));
    }
    
}