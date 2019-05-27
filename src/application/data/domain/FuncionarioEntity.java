package application.data.domain;

import application.data.domain.base.BaseEntity;

public class FuncionarioEntity extends BaseEntity {

    public FuncionarioEntity() {
        super("funcionarios","idFuncionario");
    }
    private int idFuncionario;
    private String nome;
    private int idFuncao;

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(int idFuncao) {
        this.idFuncao = idFuncao;
    }

    @Override
    public String toString() {
        return "FuncionarioEntity{" +
                "idFuncionario=" + idFuncionario +
                ", nome='" + nome + '\'' +
                ", idFuncao=" + idFuncao +
                ", table='" + table + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
