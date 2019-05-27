package application.mapperDto.base;

import application.data.domain.base.BaseEntity;
import application.dto.RecordDto;

public interface BaseMapperDto <C extends BaseEntity, D extends RecordDto>{
    C fromDtoToEntity(D dto);

    D fromEntityToDto(C entity);
}
