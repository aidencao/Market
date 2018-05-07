package cn.market.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.market.pojo.RdSession;
import cn.market.pojo.RdSessionExample;

public interface RdSessionMapper {
    int countByExample(RdSessionExample example);

    int deleteByExample(RdSessionExample example);

    int deleteByPrimaryKey(String rdsession);

    int insert(RdSession record);

    int insertSelective(RdSession record);

    List<RdSession> selectByExample(RdSessionExample example);

    RdSession selectByPrimaryKey(String rdsession);

    int updateByExampleSelective(@Param("record") RdSession record, @Param("example") RdSessionExample example);

    int updateByExample(@Param("record") RdSession record, @Param("example") RdSessionExample example);

    int updateByPrimaryKeySelective(RdSession record);

    int updateByPrimaryKey(RdSession record);
}