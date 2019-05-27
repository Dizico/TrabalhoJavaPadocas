package application.data.mapper.base;

import application.data.domain.base.BaseEntity;

import java.sql.ResultSet;

public interface BaseMapper <I extends BaseEntity> {
	I fromResultSetToEntity(ResultSet dto);
}
