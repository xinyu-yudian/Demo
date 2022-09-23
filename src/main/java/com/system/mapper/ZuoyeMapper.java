package com.system.mapper;

import com.system.po.Zuoye;
import com.system.po.ZuoyeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZuoyeMapper {
    int countByExample(ZuoyeExample example);

    int deleteByExample(ZuoyeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Zuoye record);

    int insertSelective(Zuoye record);

    List<Zuoye> selectByExample(ZuoyeExample example);

    Zuoye selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Zuoye record, @Param("example") ZuoyeExample example);

    int updateByExample(@Param("record") Zuoye record, @Param("example") ZuoyeExample example);

    int updateByPrimaryKeySelective(Zuoye record);

    int updateByPrimaryKey(Zuoye record);
}