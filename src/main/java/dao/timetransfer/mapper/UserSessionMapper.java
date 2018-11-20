package dao.timetransfer.mapper;

import dao.timetransfer.po.UserSession;
import dao.timetransfer.po.UserSessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSessionMapper {
    long countByExample(UserSessionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserSession record);

    int insertSelective(UserSession record);

    List<UserSession> selectByExample(UserSessionExample example);

    UserSession selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserSession record, @Param("example") UserSessionExample example);

    int updateByExample(@Param("record") UserSession record, @Param("example") UserSessionExample example);

    int updateByPrimaryKeySelective(UserSession record);

    int updateByPrimaryKey(UserSession record);
}