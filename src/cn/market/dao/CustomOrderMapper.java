package cn.market.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.market.pojo.CustomOrder;
import cn.market.pojo.CustomOrderExample;

public interface CustomOrderMapper {
    int countByExample(CustomOrderExample example);

    int deleteByExample(CustomOrderExample example);

    int deleteByPrimaryKey(String orderid);

    int insert(CustomOrder record);

    int insertSelective(CustomOrder record);

    List<CustomOrder> selectByExample(CustomOrderExample example);

    CustomOrder selectByPrimaryKey(String orderid);

    int updateByExampleSelective(@Param("record") CustomOrder record, @Param("example") CustomOrderExample example);

    int updateByExample(@Param("record") CustomOrder record, @Param("example") CustomOrderExample example);

    int updateByPrimaryKeySelective(CustomOrder record);

    int updateByPrimaryKey(CustomOrder record);
}