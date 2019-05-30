package application.data.domain;

import application.data.domain.base.BaseEntity;

public class FuncaoEntity extends BaseEntity {

    public FuncaoEntity() {
        super("funcao","idFuncao");
    }

    private int idFuncao;
    private String nome;

    public int getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(int idFuncao) {
        this.idFuncao = idFuncao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
