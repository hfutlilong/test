package handler;

import entity.enums.RobotStatusEnum;
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
public class RobotStatusEnumTypeHandler extends BaseTypeHandler<RobotStatusEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, RobotStatusEnum robotStatusEnum,
                                    JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, robotStatusEnum.getIntValue());
    }

    @Override
    public RobotStatusEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int intValue = resultSet.getInt(s);
        return resultSet.wasNull() ? null : RobotStatusEnum.valueOf(intValue);
    }

    @Override
    public RobotStatusEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int intValue = resultSet.getInt(i);
        return resultSet.wasNull() ? null : RobotStatusEnum.valueOf(intValue);
    }

    @Override
    public RobotStatusEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int intValue = callableStatement.getInt(i);
        return callableStatement.wasNull() ? null : RobotStatusEnum.valueOf(intValue);
    }
}
