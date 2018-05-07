package cn.market.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.market.pojo.MachineInfo;
import cn.market.pojo.MachineInfoExample;

public interface MachineInfoMapper {
    int countByExample(MachineInfoExample example);

    int deleteByExample(MachineInfoExample example);

    int deleteByPrimaryKey(String macid);

    int insert(MachineInfo record);

    int insertSelective(MachineInfo record);

    List<MachineInfo> selectByExample(MachineInfoExample example);

    MachineInfo selectByPrimaryKey(String macid);

    int updateByExampleSelective(@Param("record") MachineInfo record, @Param("example") MachineInfoExample example);

    int updateByExample(@Param("record") MachineInfo record, @Param("example") MachineInfoExample example);

    int updateByPrimaryKeySelective(MachineInfo record);

    int updateByPrimaryKey(MachineInfo record);
}