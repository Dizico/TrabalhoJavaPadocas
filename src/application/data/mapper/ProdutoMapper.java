package application.data.mapper;

import application.data.domain.ProdutoEntity;
import application.data.mapper.base.BaseMapper;
import application.exceptions.ErroGenericoExcecao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoMapper implements BaseMapper<ProdutoEntity> {
    @Override
    public ProdutoEntity fromResultSetToEntity(ResultSet dto) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        try {
            produtoEntity.setIdTipo(dto.getInt("idTipo"));
            produtoEntity.setNome(dto.getString("nome"));
            produtoEntity.setPreco(dto.getDouble("preco"));
            produtoEntity.setIdProduto(dto.getInt("idProduto"));
            return produtoEntity;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ErroGenericoExcecao("Erro no mapeamento para Produto Entity",23);
        }
    }
}
