package cn.market.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.market.pojo.DeliveryOrder;
import cn.market.pojo.DeliveryOrderExample;

public interface DeliveryOrderMapper {
    int countByExample(DeliveryOrderExample example);

    int deleteByExample(DeliveryOrderExample example);

    int deleteByPrimaryKey(String deliveryid);

    int insert(DeliveryOrder record);

    int insertSelective(DeliveryOrder record);

    List<DeliveryOrder> selectByExampleWithBLOBs(DeliveryOrderExample example);

    List<DeliveryOrder> selectByExample(DeliveryOrderExample example);

    DeliveryOrder selectByPrimaryKey(String deliveryid);

    int updateByExampleSelective(@Param("record") DeliveryOrder record, @Param("example") DeliveryOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") DeliveryOrder record, @Param("example") DeliveryOrderExample example);

    int updateByExample(@Param("record") DeliveryOrder record, @Param("example") DeliveryOrderExample example);

    int updateByPrimaryKeySelective(DeliveryOrder record);

    int updateByPrimaryKeyWithBLOBs(DeliveryOrder record);

    int updateByPrimaryKey(DeliveryOrder record);
}