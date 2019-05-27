package application.dto;

import javafx.beans.property.SimpleStringProperty;

public class FuncionariosCadastradosDto implements RecordDto {
    private SimpleStringProperty nome = new SimpleStringProperty();
    private SimpleStringProperty codigo = new SimpleStringProperty();
    private SimpleStringProperty funcaoId = new SimpleStringProperty();
    private SimpleStringProperty funcao = new SimpleStringProperty();

    public String getFuncao() {
        return funcao.get();
    }

    public SimpleStringProperty funcaoProperty() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao.set(funcao);
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getCodigo() {
        return codigo.get();
    }

    public SimpleStringProperty codigoProperty() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo.set(codigo);
    }

    public String getFuncaoId() {
        return funcaoId.get();
    }

    public SimpleStringProperty funcaoIdProperty() {
        return funcaoId;
    }

    public void setFuncaoId(String funcaoId) {
        this.funcaoId.set(funcaoId);
    }

}
