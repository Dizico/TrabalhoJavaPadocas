package application.mapperDto;

import application.data.domain.ProdutoEntity;
import application.dto.ProdutoDto;
import application.exceptions.CampoInvalidoExcecao;
import application.mapperDto.base.BaseMapperDto;

public class ProdutoMapperDto implements BaseMapperDto<ProdutoEntity, ProdutoDto> {
    @Override
    public ProdutoEntity fromDtoToEntity(ProdutoDto dto) {
        try {
            ProdutoEntity produtoEntity = new ProdutoEntity();
            produtoEntity.setNome(dto.getDescricao());
            produtoEntity.setIdTipo(Integer.parseInt(dto.getTipo()));
            produtoEntity.setPreco(Double.parseDouble(dto.getPreco()));
            return produtoEntity;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CampoInvalidoExcecao("Campos inválidos");
        }
    }

    @Override
    public ProdutoDto fromEntityToDto(ProdutoEntity entity) {
        return null;
    }
}
