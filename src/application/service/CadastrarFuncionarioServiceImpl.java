package application.service;

import application.data.dao.FuncionarioDao;
import application.data.dao.base.BaseDao;
import application.data.domain.FuncionarioEntity;
import application.data.domain.base.BaseEntity;
import application.dto.FuncionarioDto;
import application.exceptions.ErroGenericoExcecao;
import application.mapperDto.FuncionarioMapperDto;
import application.mapperDto.base.BaseMapperDto;

import java.sql.SQLException;

public class CadastrarFuncionarioServiceImpl  {

    private BaseDao funcionarioDao;

    private BaseMapperDto mapperDto;

    public CadastrarFuncionarioServiceImpl() {
        this.funcionarioDao = new FuncionarioDao();
        this.mapperDto = new FuncionarioMapperDto();
    }

    public void cadastrar(FuncionarioDto funcionarioDto){
        BaseEntity funcionarioEntity = mapperDto.fromDtoToEntity(funcionarioDto);
        try {
            funcionarioDao.save(funcionarioEntity);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new ErroGenericoExcecao("Campos não encontrados. Não foi possível salvar no banco.",41);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ErroGenericoExcecao("Campos não encontrados. Não foi possível salvar no banco.",42);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new ErroGenericoExcecao("Campos não encontrados. Não foi possível salvar no banco.",43);
        }
    }
}
