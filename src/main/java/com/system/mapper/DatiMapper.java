package com.system.mapper;

import com.system.po.Dati;
import com.system.po.DatiExample;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface DatiMapper {
    int countByExample(DatiExample example);

    int deleteByExample(DatiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dati record);

    int insertSelective(Dati record);

    List<Dati> selectByExample(DatiExample example);

    Dati selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dati record, @Param("example") DatiExample example);

    int updateByExample(@Param("record") Dati record, @Param("example") DatiExample example);

    int updateByPrimaryKeySelective(Dati record);

    int updateByPrimaryKey(Dati record);

    List<Dati> selectdati(Integer teaid);

}