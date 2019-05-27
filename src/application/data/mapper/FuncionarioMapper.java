package application.data.mapper;

import application.data.domain.FuncionarioEntity;
import application.data.mapper.base.BaseMapper;
import application.exceptions.ErroGenericoExcecao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioMapper implements BaseMapper<FuncionarioEntity> {
	@Override
	public FuncionarioEntity fromResultSetToEntity(ResultSet dto) {
		try {
			FuncionarioEntity funcionarioEntity = new FuncionarioEntity();
			funcionarioEntity.setNome(dto.getString("nome"));
			funcionarioEntity.setIdFuncao(dto.getInt("idFuncao"));
			funcionarioEntity.setIdFuncionario(dto.getInt("idFuncionario"));
			return funcionarioEntity;
		} catch (SQLException e) {
			throw new ErroGenericoExcecao("Erro no mapeamento para Funcionario Entity",21);
		}
	}
}
