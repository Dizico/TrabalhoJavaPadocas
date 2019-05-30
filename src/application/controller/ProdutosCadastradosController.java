package application.controller;

import application.dto.ProdutosCadastradosDto;
import application.exceptions.CampoInvalidoExcecao;
import application.service.ProdutosCadastradosServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static application.util.Utils.TelaSucesso;

public class ProdutosCadastradosController implements Initializable {


    @FXML
    private TableView<ProdutosCadastradosDto> tabelaProdutos;
    @FXML
    private TableColumn<ProdutosCadastradosDto, Integer> colunaTipo;
    @FXML
    private TableColumn<ProdutosCadastradosDto, String> colunaDescricao;
    @FXML
    private TableColumn<ProdutosCadastradosDto, String> colunaPreco;
    @FXML
    private TextField textPesquisar;
    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnRemoverProduto;

    private ProdutosCadastradosServiceImpl service;

    private List<ProdutosCadastradosDto> produtoDtoList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        service = new ProdutosCadastradosServiceImpl();

        produtoDtoList = service.getListaDeProdutos();

        colunaTipo.setCellValueFactory(
                new PropertyValueFactory<>("idProduto")
        );

        colunaDescricao.setCellValueFactory(
                new PropertyValueFactory<>("nome")
        );
        colunaPreco.setCellValueFactory(
                new PropertyValueFactory<>("preco")
        );
        tabelaProdutos.setItems(getObservableList(produtoDtoList));
    }

    private ObservableList<ProdutosCadastradosDto> getObservableList(List<ProdutosCadastradosDto> list) {
        ObservableList observableList = FXCollections.observableList(list);
        return observableList;
    }

    public void removerProduto(ActionEvent actionEvent){
        ProdutosCadastradosDto selectedItem = tabelaProdutos.getSelectionModel().getSelectedItem();
        if(selectedItem == null){
            throw new CampoInvalidoExcecao("Necessário selecionar um funcionário");
        }
        service.deleteFuncionario(selectedItem);
        produtoDtoList = produtoDtoList.stream().filter(funcionario->funcionario.getIdProduto()!=(selectedItem.getIdProduto())).collect(Collectors.toList());
        tabelaProdutos.setItems(getObservableList(produtoDtoList));
        TelaSucesso("Produto removido");

    }

    public void filtrar(ActionEvent actionEvent) {
        String text = textPesquisar.getText().trim();
        if(text.equals("")) {
            tabelaProdutos.setItems(getObservableList(produtoDtoList));
            return;
        }
        try {
            int i = Integer.parseInt(text);
            List<ProdutosCadastradosDto> collect = produtoDtoList.stream().filter(func -> func.getIdProduto()==i).collect(Collectors.toList());
            tabelaProdutos.setItems(getObservableList(collect));
            return;
        } catch (Exception e) {
            List<ProdutosCadastradosDto> collect = produtoDtoList.stream().filter(func -> func.getNome().contains(text)).collect(Collectors.toList());
            tabelaProdutos.setItems(getObservableList(collect));
            return;
        }
    }

}
