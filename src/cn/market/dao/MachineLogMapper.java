package cn.market.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.market.pojo.MachineLog;
import cn.market.pojo.MachineLogExample;

public interface MachineLogMapper {
    int countByExample(MachineLogExample example);

    int deleteByExample(MachineLogExample example);

    int deleteByPrimaryKey(String maclogid);

    int insert(MachineLog record);

    int insertSelective(MachineLog record);

    List<MachineLog> selectByExample(MachineLogExample example);

    MachineLog selectByPrimaryKey(String maclogid);

    int updateByExampleSelective(@Param("record") MachineLog record, @Param("example") MachineLogExample example);

    int updateByExample(@Param("record") MachineLog record, @Param("example") MachineLogExample example);

    int updateByPrimaryKeySelective(MachineLog record);

    int updateByPrimaryKey(MachineLog record);
}