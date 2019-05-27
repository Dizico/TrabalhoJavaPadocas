package application.mapperDto;

import application.data.domain.FuncionarioEntity;
import application.dto.FuncionariosCadastradosDto;
import application.mapperDto.base.BaseMapperDto;

public class FuncionariosCadastradosMapperDto implements BaseMapperDto<FuncionarioEntity,FuncionariosCadastradosDto> {
    @Override
    public FuncionarioEntity fromDtoToEntity(FuncionariosCadastradosDto dto) {
        FuncionarioEntity funcionarioEntity = new FuncionarioEntity();
        funcionarioEntity.setIdFuncionario(Integer.parseInt(dto.getCodigo()));
        funcionarioEntity.setNome(dto.getNome());
        funcionarioEntity.setIdFuncao(Integer.parseInt(dto.getFuncaoId()));
        return funcionarioEntity;
    }

    @Override
    public FuncionariosCadastradosDto fromEntityToDto(FuncionarioEntity entity) {
        FuncionariosCadastradosDto dto = new FuncionariosCadastradosDto();
        dto.setCodigo(String.valueOf(entity.getIdFuncionario()));
        dto.setFuncaoId(String.valueOf(entity.getIdFuncao()));
        dto.setNome(entity.getNome());
        return dto;
    }
}
