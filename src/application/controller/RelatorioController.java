package application.controller;

import application.service.RelatorioServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RelatorioController implements Initializable {


    @FXML
    public Button btnGerarRelatorio;
    @FXML
    public TextField dataDe;
    @FXML
    public TextField dataAte;
    @FXML
    public TextField tipoAte;
    @FXML
    public TextField tipoDe;

    private RelatorioServiceImpl service;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void gerarGrafico(ActionEvent actionEvent) {
        int tipoA = Integer.parseInt(this.tipoAte.getText());
        int tipoD = Integer.parseInt(tipoDe.getText());
        int tipos = Math.abs(tipoA-tipoD);
        for(int i = 0; i<tipos; i++)
        {
//            service.vendas(tipo,dataDe.getText(),dataAte.getText());
        }
        montarGrafico();
    }

    public void montarGrafico(){
        Stage stage = new Stage();
        VBox vBox = new VBox();
        PieChart graficoPizza = new PieChart();
        graficoPizza.getData()
                .addAll(
                        new PieChart.Data("Trimestre 1", 11),
                        new PieChart.Data("Trimestre 2", 1),
                        new PieChart.Data("Trimestre 3", 24),
                        new PieChart.Data("Trimestre 5", 12)
                );
        graficoPizza.setTitle("Vendas");
        graficoPizza.setPrefSize(200, 200);
        Button button = new Button("Fechar");
        button.setOnAction(action -> stage.close());
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(graficoPizza, button);
        Scene scene = new Scene(vBox, 300, 300);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
