package application.util;

import application.exceptions.CampoInvalidoExcecao;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {

    @SuppressWarnings("unchecked")
    public static Connection getConnection() {
        try {
            DataSource dataSource = DataSourceFactory.getDataSource();
            Connection con = dataSource.getConnection();
            return con;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void TelaSucesso(String mensagem){
        Stage stage = new Stage();
        VBox stackPane = new VBox(10);
        Label label = new Label(mensagem);
        Button button = new Button("OK");

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Error");

        button.setOnAction(action->stage.close());

        stackPane.setMinHeight(200);
        stackPane.setMinWidth(200);
        stackPane.getChildren().setAll(label,button);
        stackPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(stackPane,200,200);

        stage.setScene(scene);

        stage.showAndWait();
    }

    public static void TelaErro(String mensagem){
        Stage stage = new Stage();
        VBox stackPane = new VBox(10);
        Label label = new Label(mensagem);
        Button button = new Button("OK");

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Error");

        button.setOnAction(action->stage.close());

        stackPane.setMinHeight(200);
        stackPane.setMinWidth(200);
        stackPane.getChildren().setAll(label,button);
        stackPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(stackPane,200,200);

        stage.setScene(scene);

        stage.showAndWait();

    }

}
