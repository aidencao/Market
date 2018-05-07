package cn.market.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.market.pojo.CustomOrderDetail;
import cn.market.pojo.CustomOrderDetailExample;

public interface CustomOrderDetailMapper {
    int countByExample(CustomOrderDetailExample example);

    int deleteByExample(CustomOrderDetailExample example);

    int insert(CustomOrderDetail record);

    int insertSelective(CustomOrderDetail record);

    List<CustomOrderDetail> selectByExample(CustomOrderDetailExample example);

    int updateByExampleSelective(@Param("record") CustomOrderDetail record, @Param("example") CustomOrderDetailExample example);

    int updateByExample(@Param("record") CustomOrderDetail record, @Param("example") CustomOrderDetailExample example);
}