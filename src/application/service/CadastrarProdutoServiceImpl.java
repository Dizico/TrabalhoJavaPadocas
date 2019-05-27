package application.service;

import application.data.dao.ProdutoDao;
import application.data.dao.base.BaseDao;
import application.data.domain.base.BaseEntity;
import application.dto.ProdutoDto;
import application.exceptions.ErroGenericoExcecao;
import application.mapperDto.ProdutoMapperDto;
import application.mapperDto.base.BaseMapperDto;

import java.sql.SQLException;

public class CadastrarProdutoServiceImpl {

    private BaseMapperDto mapper;
    private BaseDao dao;

    public CadastrarProdutoServiceImpl() {
        this.mapper = new ProdutoMapperDto();
        this.dao = new ProdutoDao();
    }

    public void cadastrarProduto(ProdutoDto dto){
        BaseEntity entity = mapper.fromDtoToEntity(dto);
        try {
            dao.save(entity);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new ErroGenericoExcecao("Campos não encontrados. Não foi possível salvar no banco.",44);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ErroGenericoExcecao("Campos não encontrados. Não foi possível salvar no banco.",45);
        } catch (IllegalAccessException e) {
            throw new ErroGenericoExcecao("Campos não encontrados. Não foi possível salvar no banco.",46);
        }
    }
}
