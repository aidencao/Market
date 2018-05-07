package cn.market.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.market.pojo.CustomComplain;
import cn.market.pojo.CustomComplainExample;

public interface CustomComplainMapper {
    int countByExample(CustomComplainExample example);

    int deleteByExample(CustomComplainExample example);

    int deleteByPrimaryKey(String customcomplainid);

    int insert(CustomComplain record);

    int insertSelective(CustomComplain record);

    List<CustomComplain> selectByExample(CustomComplainExample example);

    CustomComplain selectByPrimaryKey(String customcomplainid);

    int updateByExampleSelective(@Param("record") CustomComplain record, @Param("example") CustomComplainExample example);

    int updateByExample(@Param("record") CustomComplain record, @Param("example") CustomComplainExample example);

    int updateByPrimaryKeySelective(CustomComplain record);

    int updateByPrimaryKey(CustomComplain record);
}