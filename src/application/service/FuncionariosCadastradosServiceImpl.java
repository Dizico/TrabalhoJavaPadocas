package application.service;

import application.data.dao.FuncaoDao;
import application.data.dao.FuncionarioDao;
import application.data.domain.FuncaoEntity;
import application.data.domain.FuncionarioEntity;
import application.dto.FuncionariosCadastradosDto;
import application.mapperDto.FuncionariosCadastradosMapperDto;
import application.mapperDto.base.BaseMapperDto;

import java.util.ArrayList;
import java.util.List;

public class FuncionariosCadastradosServiceImpl {

    private BaseMapperDto mapperDto;
    private FuncionarioDao funcionarioDao;
    private FuncaoDao funcaoDao;


    public FuncionariosCadastradosServiceImpl() {
        this.funcionarioDao = new FuncionarioDao();
        this.funcaoDao = new FuncaoDao();
        this.mapperDto = new FuncionariosCadastradosMapperDto();
    }

    public List<FuncionariosCadastradosDto> getListFuncaoAndFuncionario() {

        List funcionarios = funcionarioDao.findByQuery();
        List<FuncaoEntity> funcoes = funcaoDao.findByQuery();
        List resposta = convertList(funcionarios,funcoes);
        return resposta;
    }

    public void deleteFuncionario(FuncionariosCadastradosDto dto){
        funcionarioDao.delete((FuncionarioEntity) mapperDto.fromDtoToEntity(dto));
    }

    private List<FuncionariosCadastradosDto> convertList(List<FuncionarioEntity> funcionarioDaoList, List<FuncaoEntity> funcoes){
        List<FuncionariosCadastradosDto> list= new ArrayList<>();
        funcionarioDaoList.forEach(funcionario->list.add((FuncionariosCadastradosDto) mapperDto.fromEntityToDto(funcionario)));
        list.forEach(item->{
            funcoes.forEach(funcao->{
                if(item.getFuncaoId().equals(String.valueOf(funcao.getIdFuncao())))
                    item.setFuncao(funcao.getNome());
            });
        });
        return list;
    }

}
