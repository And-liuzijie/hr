package com.briup.mapper;

import com.briup.bean.Extrawork;
import com.briup.bean.ExtraworkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExtraworkMapper {
    int countByExample(ExtraworkExample example);

    int deleteByExample(ExtraworkExample example);

    int deleteByPrimaryKey(String id);

    int insert(Extrawork record);

    int insertSelective(Extrawork record);

    List<Extrawork> selectByExample(ExtraworkExample example);

    Extrawork selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Extrawork record, @Param("example") ExtraworkExample example);

    int updateByExample(@Param("record") Extrawork record, @Param("example") ExtraworkExample example);

    int updateByPrimaryKeySelective(Extrawork record);

    int updateByPrimaryKey(Extrawork record);
}