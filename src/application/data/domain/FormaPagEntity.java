package application.data.domain;

import application.data.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class FormaPagEntity extends BaseEntity {

    public FormaPagEntity() {
        super("FormaPag","idFormaPag");
    }

    private int idFormaPag;
    private String nome;
}
