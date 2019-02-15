package handler;

import common.enums.KeyValueBizTypeEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KeyValueBizTypeEnumTypeHandler extends BaseTypeHandler<KeyValueBizTypeEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, KeyValueBizTypeEnum bizTypeEnum,
                                    JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, bizTypeEnum.name());
    }

    @Override
    public KeyValueBizTypeEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String name = resultSet.getString(s);
        return resultSet.wasNull() ? null : KeyValueBizTypeEnum.valueOf(name);
    }

    @Override
    public KeyValueBizTypeEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String name = resultSet.getString(i);
        return resultSet.wasNull() ? null : KeyValueBizTypeEnum.valueOf(name);
    }

    @Override
    public KeyValueBizTypeEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String name = callableStatement.getString(i);
        return callableStatement.wasNull() ? null : KeyValueBizTypeEnum.valueOf(name);
    }
}

