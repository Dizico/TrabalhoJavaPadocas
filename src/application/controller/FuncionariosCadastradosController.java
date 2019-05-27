package application.controller;

import application.data.dao.FuncionarioDao;
import application.data.dao.base.BaseDao;
import application.dto.FuncionariosCadastradosDto;
import application.exceptions.CampoInvalidoExcecao;
import application.mapperDto.FuncionarioMapperDto;
import application.mapperDto.FuncionariosCadastradosMapperDto;
import application.mapperDto.base.BaseMapperDto;
import application.service.FuncionariosCadastradosServiceImpl;
import application.util.Utils;
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

import static application.util.Utils.*;

public class FuncionariosCadastradosController implements Initializable {

    private BaseDao dao;
    private BaseMapperDto mapperDto;

    @FXML
    private TableView<FuncionariosCadastradosDto> tabelaFuncionarios;
    @FXML
    private TableColumn<FuncionariosCadastradosDto, String> colunaCodigo;
    @FXML
    private TableColumn<FuncionariosCadastradosDto, String> colunaNome;
    @FXML
    private TableColumn<FuncionariosCadastradosDto, String> colunaFuncao;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnPesquisar;
    @FXML
    private TextField textPesquisa;

    private FuncionariosCadastradosServiceImpl service;

    private List<FuncionariosCadastradosDto> listFuncaoAndFuncionario;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dao = new FuncionarioDao();
        mapperDto = new FuncionariosCadastradosMapperDto();
        service = new FuncionariosCadastradosServiceImpl();
        listFuncaoAndFuncionario = service.getListFuncaoAndFuncionario();

        colunaNome.setCellValueFactory(
                new PropertyValueFactory<>("nome")
        );
        colunaCodigo.setCellValueFactory(
                new PropertyValueFactory<>("codigo")
        );
        colunaFuncao.setCellValueFactory(
                new PropertyValueFactory<>("funcao")
        );
        tabelaFuncionarios.setItems(getObservableList(listFuncaoAndFuncionario));
    }


    public void filtrar(ActionEvent actionEvent) {
        String text = textPesquisa.getText().trim();
        if(text.equals("")) {
            tabelaFuncionarios.setItems(getObservableList(listFuncaoAndFuncionario));
            return;
        }
        try {
            int i = Integer.parseInt(text);
            List<FuncionariosCadastradosDto> collect = listFuncaoAndFuncionario.stream().filter(func -> func.getCodigo().equals(String.valueOf(i))).collect(Collectors.toList());
            tabelaFuncionarios.setItems(getObservableList(collect));
            return;
        } catch (Exception e) {
            List<FuncionariosCadastradosDto> collect = listFuncaoAndFuncionario.stream().filter(func -> func.getNome().contains(text)).collect(Collectors.toList());
            tabelaFuncionarios.setItems(getObservableList(collect));
            return;
        }
    }


    public void removerFuncionario(ActionEvent actionEvent){
        FuncionariosCadastradosDto selectedItem = tabelaFuncionarios.getSelectionModel().getSelectedItem();
        if(selectedItem == null){
            throw new CampoInvalidoExcecao("Necessário selecionar um funcionário");
        }
        service.deleteFuncionario(selectedItem);
        listFuncaoAndFuncionario = listFuncaoAndFuncionario.stream().filter(funcionario->!funcionario.getCodigo().equals(selectedItem.getCodigo())).collect(Collectors.toList());
        tabelaFuncionarios.setItems(getObservableList(listFuncaoAndFuncionario));
        TelaSucesso("Funcionário removido");

    }

    private ObservableList<FuncionariosCadastradosDto> getObservableList(List<FuncionariosCadastradosDto> list) {
        ObservableList observableList = FXCollections.observableList(list);
        return observableList;
    }



}
