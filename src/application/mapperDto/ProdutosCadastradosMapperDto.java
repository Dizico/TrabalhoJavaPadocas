package application.mapperDto;

import application.data.domain.ProdutoEntity;
import application.dto.ProdutosCadastradosDto;
import application.mapperDto.base.BaseMapperDto;

public class ProdutosCadastradosMapperDto implements BaseMapperDto<ProdutoEntity, ProdutosCadastradosDto> {
    @Override
    public ProdutoEntity fromDtoToEntity(ProdutosCadastradosDto dto) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setIdProduto(dto.getIdProduto());
        produtoEntity.setPreco(dto.getPreco());
        produtoEntity.setNome(dto.getNome());
        produtoEntity.setIdTipo(dto.getIdTipo());
        return produtoEntity;
    }

    @Override
    public ProdutosCadastradosDto fromEntityToDto(ProdutoEntity entity) {
        ProdutosCadastradosDto dto = new ProdutosCadastradosDto();
        dto.setIdProduto(entity.getIdProduto());
        dto.setIdTipo(entity.getIdTipo());
        dto.setNome(entity.getNome());
        dto.setPreco(entity.getPreco());
        return dto;
    }
}
