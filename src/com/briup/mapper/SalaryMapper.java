package com.briup.mapper;

import com.briup.bean.Salary;
import com.briup.bean.SalaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalaryMapper {
    int countByExample(SalaryExample example);

    int deleteByExample(SalaryExample example);

    int insert(Salary record);

    int insertSelective(Salary record);

    List<Salary> selectByExample(SalaryExample example);

    int updateByExampleSelective(@Param("record") Salary record, @Param("example") SalaryExample example);

    int updateByExample(@Param("record") Salary record, @Param("example") SalaryExample example);
}