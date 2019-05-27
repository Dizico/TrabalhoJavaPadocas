package application.controller;

import application.dto.FuncionarioDto;
import application.exceptions.CampoInvalidoExcecao;
import application.service.CadastrarFuncionarioServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static application.util.Utils.TelaSucesso;

public class CadastrarFuncionarioController implements Initializable {
    @FXML
    private Button btnCadastrarFuncionario;

    @FXML
    private TextField textNome;

    @FXML
    private TextField textCodigo;

    @FXML
    private TextField textFuncao;

    private FuncionarioDto funcionarioDto;

    private CadastrarFuncionarioServiceImpl service;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.funcionarioDto = new FuncionarioDto();
        service = new CadastrarFuncionarioServiceImpl();

    }

    public void cadastrarFuncionario(ActionEvent event) {
        try {
            setDto();
            service.cadastrar(funcionarioDto);
            TelaSucesso("Funcionario cadastrado com sucesso");
            limparCampos();
        } catch (CampoInvalidoExcecao e) {
            e.printStackTrace();
        }
    }

    private void setDto() {
        if (textNome.getText().trim().length() == 0)
            throw new CampoInvalidoExcecao("Necessário preencher o nome");
        else if (textCodigo.getText().trim().length() == 0)
            throw new CampoInvalidoExcecao("Necessário preencher o código");
        else if (textFuncao.getText().trim().length() == 0)
            throw new CampoInvalidoExcecao("Necessário preencher a função");

        funcionarioDto.setNome(textNome.getText());
        funcionarioDto.setCodigo(textCodigo.getText());
        funcionarioDto.setFuncaoId(textFuncao.getText());
    }

    private void limparCampos() {
        textNome.setText("");
        textFuncao.setText("");
        textCodigo.setText("");
    }
}
