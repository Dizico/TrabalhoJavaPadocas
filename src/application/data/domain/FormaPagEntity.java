package application.data.domain;

import application.data.domain.base.BaseEntity;
public class FormaPagEntity extends BaseEntity {

    public FormaPagEntity() {
        super("FormaPag","idFormaPag");
    }

    private int idFormaPag;
    private String nome;

    public int getIdFormaPag() {
        return idFormaPag;
    }

    public void setIdFormaPag(int idFormaPag) {
        this.idFormaPag = idFormaPag;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
