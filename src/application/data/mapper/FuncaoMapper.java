package application.data.mapper;

import application.data.domain.FuncaoEntity;
import application.data.mapper.base.BaseMapper;
import application.exceptions.ErroGenericoExcecao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncaoMapper implements BaseMapper<FuncaoEntity> {
    @Override
    public FuncaoEntity fromResultSetToEntity(ResultSet dto) {

        try {
            FuncaoEntity funcao = new FuncaoEntity();
            funcao.setIdFuncao(dto.getInt("idFuncao"));
            funcao.setNome(dto.getString("nome"));
            return funcao;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ErroGenericoExcecao("Erro no mapeamento para Funcionario Entity",22);
        }
    }
}
