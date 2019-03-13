package handler;

import entity.enums.RobotTypeEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-03-13 16:16
 */
public class RobotTypeEnumTypeHandler extends BaseTypeHandler<RobotTypeEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, RobotTypeEnum robotTypeEnum,
                                    JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, robotTypeEnum.getIntValue());
    }

    @Override
    public RobotTypeEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int intValue = resultSet.getInt(s);
        return resultSet.wasNull() ? null : RobotTypeEnum.valueOf(intValue);
    }

    @Override
    public RobotTypeEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int intValue = resultSet.getInt(i);
        return resultSet.wasNull() ? null : RobotTypeEnum.valueOf(intValue);
    }

    @Override
    public RobotTypeEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int intValue = callableStatement.getInt(i);
        return callableStatement.wasNull() ? null : RobotTypeEnum.valueOf(intValue);
    }
}