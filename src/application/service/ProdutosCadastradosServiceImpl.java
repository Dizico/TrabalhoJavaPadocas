package application.service;

import application.data.dao.ProdutoDao;
import application.data.domain.ProdutoEntity;
import application.dto.ProdutosCadastradosDto;
import application.mapperDto.ProdutoMapperDto;
import application.mapperDto.ProdutosCadastradosMapperDto;
import application.mapperDto.base.BaseMapperDto;

import java.util.ArrayList;
import java.util.List;

public class ProdutosCadastradosServiceImpl {
    private BaseMapperDto mapperDto;
    private ProdutoDao produtoDao;

    public ProdutosCadastradosServiceImpl() {
        this.mapperDto = new ProdutosCadastradosMapperDto();
        this.produtoDao = new ProdutoDao();
    }

    public List<ProdutosCadastradosDto> getListaDeProdutos(){
        List<ProdutoEntity> produtos = produtoDao.findByQuery();
        List<ProdutosCadastradosDto> produtoDtos = new ArrayList<>();
        produtos.forEach(produtoEntity -> produtoDtos.add((ProdutosCadastradosDto)mapperDto.fromEntityToDto(produtoEntity)));
        return produtoDtos;
    }

    public void deleteFuncionario(ProdutosCadastradosDto dto){
        produtoDao.delete((ProdutoEntity) mapperDto.fromDtoToEntity(dto));
    }
}
