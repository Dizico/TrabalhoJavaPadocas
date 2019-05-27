package application.dto;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class ItemComanda implements RecordDto{
	
    private final SimpleIntegerProperty codigo;
	private final SimpleStringProperty descricao;

    public ItemComanda(Integer codigo, String descricao) {
        this.codigo = new SimpleIntegerProperty(codigo);
        this.descricao = new SimpleStringProperty(descricao);
    }
}