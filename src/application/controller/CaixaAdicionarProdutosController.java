package application.controller;

import application.exceptions.CampoInvalidoExcecao;
import application.service.CaixaAdicionarProdutosServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CaixaAdicionarProdutosController implements Initializable {



    @FXML
    public TableView tabelaComanda;

    @FXML
    public TableColumn codigoCol;

    @FXML
    public TableColumn descricaoCol;

    @FXML
    public Button btnBuscar;

    @FXML
    public TextField textComanda;

    private CaixaAdicionarProdutosServiceImpl service;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public CaixaAdicionarProdutosController() {
        service = new CaixaAdicionarProdutosServiceImpl();
    }

    public void buscar(ActionEvent actionEvent){
        String text = textComanda.getText();
        if(text==null || text=="")
            throw new CampoInvalidoExcecao("Necessário preencher o campo");
//        service.buscarComanda();

    }


}
