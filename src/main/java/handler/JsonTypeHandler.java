package handler;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JSON类型解析
 * @param <T>
 */
public class JsonTypeHandler<T> extends BaseTypeHandler<T> {
    private Class<T> clazz;

    public JsonTypeHandler(Class<T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.clazz = clazz;
    }


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, T parameter,
                                    JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, this.toJsonString(parameter));
    }

    @Override
    public T getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String stringValue = resultSet.getString(s);
        return resultSet.wasNull() ? null : this.parseJson(stringValue);
    }

    @Override
    public T getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String stringValue = resultSet.getString(i);
        return resultSet.wasNull() ? null : this.parseJson(stringValue);
    }

    @Override
    public T getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String stringValue = callableStatement.getString(i);
        return callableStatement.wasNull() ? null : this.parseJson(stringValue);
    }

    private String toJsonString(Object obj) {
        try {
            return JSON.toJSONString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private T parseJson(String content) {
        if (StringUtils.isBlank(content)) {
            return null;
        }

        try {
            return JSON.parseObject(content, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}