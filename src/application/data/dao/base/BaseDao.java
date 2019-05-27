package application.data.dao.base;

import application.data.domain.base.BaseEntity;
import application.data.mapper.base.BaseMapper;
import application.exceptions.ErroGenericoExcecao;
import application.model.Filter;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static application.util.Utils.getConnection;

public interface BaseDao<C extends BaseEntity> {

    default ResultSet findWithQuery(String sql,Object... args){
        try(Connection connection = getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                for (int i = 0; i < args.length; i++)
                    preparedStatement.setObject(i+1,args[i]);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao gravar no banco");
        }
    }

    default List<C> findByQuery(Filter... filters) {
        int filtersLength = filters.length;
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        List<C> responseList = new ArrayList<>();
        try {
            BaseEntity baseEntity = (BaseEntity) Class.forName(getClass().getName().replaceAll("Dao", "Entity").replaceAll("dao", "domain")).newInstance();
            BaseMapper<C> mapper = (BaseMapper<C>) Class.forName(getClass().getName().replaceAll("Dao", "Mapper").replaceAll("dao", "mapper")).newInstance();

            sql.append(baseEntity.getTable());

            if (filtersLength > 0) {
                sql.append(" WHERE ");
                for (int i = 0; i < filtersLength; i++) {
                    if (i + 1 < filtersLength)
                        sql.append(filters[i].getNameField() + " = ? AND ");
                    else
                        sql.append(filters[i].getNameField() + " = ? ;");
                }
            } else
                sql.append(";");
            try (Connection connection = getConnection()) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql.toString())) {
                    for (int i = 0; i < filtersLength; i++) {
                        preparedStatement.setObject(i + 1, filters[i].getValue());
                    }
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            responseList.add(mapper.fromResultSetToEntity(resultSet));
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            throw new ErroGenericoExcecao("Classe não encontrada" + e.getMessage(), 1);
        } catch (IllegalAccessException e) {
            throw new ErroGenericoExcecao("Modo de acesso à classe ilegal" + e.getMessage(), 2);
        } catch (InstantiationException e) {
            throw new ErroGenericoExcecao("Erro ao instanciar classe" + e.getMessage(), 3);
        }
        return responseList;
    }

    default boolean save(C entity) throws NoSuchFieldException, SecurityException, SQLException, IllegalAccessException {
        Class<? extends BaseEntity> clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        int fieldsLength = fields.length;
        String complements = "";
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ")
                .append(entity.getTable())
                .append(" ( ");
        for (int i = 0; i < fieldsLength; i++) {
            if (i + 1 < fieldsLength) {
                Field field = clazz.getDeclaredField(fields[i].getName());
                field.setAccessible(true);
                if(field.get(entity)!=null) {
                    sql.append(fields[i].getName() + ",");
                    complements += "?,";
                }
                else
                    continue;
            } else {
                complements += "?";
                sql.append(fields[i].getName() + ") VALUES(").append(complements + ");");
            }
        }
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql.toString())) {
                for (int i = 0; i < fieldsLength; i++) {
                    Field field = clazz.getDeclaredField(fields[i].getName());
                    field.setAccessible(true);
                    if( field.get(entity)!=null)
                        preparedStatement.setObject(i + 1, field.get(entity));
                    else
                        continue;
                }
                return preparedStatement.execute();
            }
        }
    }

    default boolean update(C entity) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
        Class<C> clazz = (Class<C>) entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        String idValue = null;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE ").append(entity.getTable()).append(" SET ");
        int fieldsLength = fields.length;
        for (int i = 0; i < fieldsLength; i++) {
            Field field = clazz.getDeclaredField((fields[i].getName()));
            field.setAccessible(true);
            if (i + 1 < fieldsLength)
                if (fields[i].getName().equals(entity.getId()))
                    idValue = field.get(entity).toString();
                else
                    sql.append(fields[i].getName() + "=" + field.get(entity) + ",");
            else
                sql.append(fields[i].getName() + "=" + field.get(entity));
        }
        sql.append(" WHERE " + entity.getId() + "=" + idValue + ";");
        System.out.println(sql.toString());
        try (Connection connection = getConnection()) {
            try (PreparedStatement prepareStatement = connection.prepareStatement(sql.toString())) {
                return prepareStatement.execute();
            }
        }
    }

    default boolean delete(C entity)  {
        Class<? extends BaseEntity> clazz = entity.getClass();
        StringBuilder sql = new StringBuilder("DELETE FROM " + entity.getTable() + " WHERE " + entity.getId() + " = ?");
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql.toString())) {
                Field field = clazz.getDeclaredField(entity.getId());
                field.setAccessible(true);
                preparedStatement.setObject(1, field.get(entity));
                return preparedStatement.execute();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                throw new ErroGenericoExcecao("Erro com base no campo",46);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new ErroGenericoExcecao("Acesso de uso ilegal à classe",47);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ErroGenericoExcecao("Erro ao deletar no banco",48);
        }
    }
}
