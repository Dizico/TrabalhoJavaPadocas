package application.controller;

import application.data.dao.ProdutoDao;
import application.dto.ProdutoDto;
import application.exceptions.CampoInvalidoExcecao;
import application.service.CadastrarFuncionarioServiceImpl;
import application.service.CadastrarProdutoServiceImpl;
import application.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastrarProdutoController implements Initializable {

    @FXML
    private TextField textDescricao;

    @FXML
    private TextField textTipo;

    @FXML
    private TextField textPreco;



    private ProdutoDto produtoDto;

    private CadastrarProdutoServiceImpl service;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        service = new CadastrarProdutoServiceImpl();
        produtoDto = new ProdutoDto();
    }

    public void cadastrarProduto(ActionEvent actionEvent){
        setDto();
        service.cadastrarProduto(produtoDto);
        Utils.TelaSucesso("Produto Cadastrado");
        limparCampos();
    }

    private void setDto() {
        if (textDescricao.getText().trim().length() == 0)
            throw new CampoInvalidoExcecao("Necessário preencher o nome");
        else if (textTipo.getText().trim().length() == 0)
            throw new CampoInvalidoExcecao("Necessário preencher o código");
        else if (textPreco.getText().trim().length() == 0)
            throw new CampoInvalidoExcecao("Necessário preencher a função");

        produtoDto.setDescricao(textDescricao.getText());
        produtoDto.setTipo(textTipo.getText());
        produtoDto.setPreco(textPreco.getText());
    }

    private void limparCampos() {
        textDescricao.setText("");
        textTipo.setText("");
        textPreco.setText("");
    }
}
