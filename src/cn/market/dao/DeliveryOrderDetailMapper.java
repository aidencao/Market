package cn.market.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.market.pojo.DeliveryOrderDetail;
import cn.market.pojo.DeliveryOrderDetailExample;

public interface DeliveryOrderDetailMapper {
    int countByExample(DeliveryOrderDetailExample example);

    int deleteByExample(DeliveryOrderDetailExample example);

    int insert(DeliveryOrderDetail record);

    int insertSelective(DeliveryOrderDetail record);

    List<DeliveryOrderDetail> selectByExample(DeliveryOrderDetailExample example);

    int updateByExampleSelective(@Param("record") DeliveryOrderDetail record, @Param("example") DeliveryOrderDetailExample example);

    int updateByExample(@Param("record") DeliveryOrderDetail record, @Param("example") DeliveryOrderDetailExample example);
}