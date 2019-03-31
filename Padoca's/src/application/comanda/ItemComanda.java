package application.comanda;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ItemComanda {
	
    private final SimpleIntegerProperty codigo;
	private final SimpleStringProperty descricao;

    public ItemComanda(Integer codigo, String descricao) {
        this.codigo = new SimpleIntegerProperty(codigo);
        this.descricao = new SimpleStringProperty(descricao);
    }
    
    public int getcodigo() {
        return codigo.get();
    }

    public SimpleIntegerProperty codigoProperty() {
        return codigo;
    }

    public void setcodigo(int codigo) {
        this.codigo.set(codigo);
    }

    public String getdescricao() {
        return descricao.get();
    }

    public SimpleStringProperty descricaoProperty() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao.set(descricao);
    }

}