package com.system.mapper;

import com.system.po.College;
import com.system.po.Coursedate;
import com.system.po.CoursedateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoursedateMapper {
    int countByExample(CoursedateExample example);

    int deleteByExample(CoursedateExample example);

    int deleteByPrimaryKey(Integer collegeid);

    int insert(Coursedate record);

    int insertSelective(Coursedate record);

    List<Coursedate> selectByExample(CoursedateExample example);

    Coursedate selectByPrimaryKey(Integer collegeid);

    int updateByExampleSelective(@Param("record") Coursedate record, @Param("example") CoursedateExample example);

    int updateByExample(@Param("record") Coursedate record, @Param("example") CoursedateExample example);

    int updateByPrimaryKeySelective(Coursedate record);

    int updateByPrimaryKey(Coursedate record);

    Coursedate  selectnew();
}