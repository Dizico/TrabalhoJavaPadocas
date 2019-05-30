package application.dto;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProdutosCadastradosDto implements RecordDto{
    private SimpleIntegerProperty idProduto = new SimpleIntegerProperty();
    private SimpleStringProperty nome = new SimpleStringProperty();
    private SimpleIntegerProperty idTipo = new SimpleIntegerProperty();
    private SimpleDoubleProperty preco = new SimpleDoubleProperty();

    public int getIdProduto() {
        return idProduto.get();
    }

    public SimpleIntegerProperty idProdutoProperty() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto.set(idProduto);
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

    public int getIdTipo() {
        return idTipo.get();
    }

    public SimpleIntegerProperty idTipoProperty() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo.set(idTipo);
    }

    public double getPreco() {
        return preco.get();
    }

    public SimpleDoubleProperty precoProperty() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco.set(preco);
    }
}
