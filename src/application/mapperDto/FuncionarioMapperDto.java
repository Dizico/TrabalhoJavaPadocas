package application.mapperDto;

import application.data.domain.FuncionarioEntity;
import application.dto.FuncionarioDto;
import application.exceptions.CampoInvalidoExcecao;
import application.mapperDto.base.BaseMapperDto;

public class FuncionarioMapperDto implements BaseMapperDto<FuncionarioEntity, FuncionarioDto> {
    @Override
    public FuncionarioEntity fromDtoToEntity(FuncionarioDto dto) {
        try {
            FuncionarioEntity funcionarioEntity = new FuncionarioEntity();
            funcionarioEntity.setNome(dto.getNome());
            funcionarioEntity.setIdFuncionario(Integer.parseInt(dto.getCodigo()));
            funcionarioEntity.setIdFuncao(Integer.parseInt(dto.getFuncaoId()));
            return funcionarioEntity;
        }
        catch(Exception e){
            e.printStackTrace();
            throw new CampoInvalidoExcecao("Campos inválidos");
        }
    }

    @Override
    public FuncionarioDto fromEntityToDto(FuncionarioEntity entity) {
        return null;
    }
}
