package cn.market.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.market.pojo.MachineBox;
import cn.market.pojo.MachineBoxExample;
import cn.market.pojo.MachineBoxKey;

public interface MachineBoxMapper {
    int countByExample(MachineBoxExample example);

    int deleteByExample(MachineBoxExample example);

    int deleteByPrimaryKey(MachineBoxKey key);

    int insert(MachineBox record);

    int insertSelective(MachineBox record);

    List<MachineBox> selectByExample(MachineBoxExample example);

    MachineBox selectByPrimaryKey(MachineBoxKey key);

    int updateByExampleSelective(@Param("record") MachineBox record, @Param("example") MachineBoxExample example);

    int updateByExample(@Param("record") MachineBox record, @Param("example") MachineBoxExample example);

    int updateByPrimaryKeySelective(MachineBox record);

    int updateByPrimaryKey(MachineBox record);
}