package application.dto;

public class FuncionarioDto implements RecordDto{

    private String nome;
    private String funcaoId;
    private String codigo;

    public FuncionarioDto() {
    }

    public FuncionarioDto(String nome, String funcaoId, String codigo) {
        this.nome = nome;
        this.funcaoId = funcaoId;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncaoId() {
        return funcaoId;
    }

    public void setFuncaoId(String funcaoId) {
        this.funcaoId = funcaoId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
