package com.system.service;

import com.system.po.Dati;

import java.util.List;

/**
 * DatiService选题信息.
 */
public interface DatiService {
    //根据id更新选题信息
    void upadteById(Integer id, Dati course) throws Exception;


    //插入选题信息
    Boolean save(Dati couseCustom) throws Exception;


    //根据id查询
    Dati findById(Integer id) throws Exception;


    //根据学生id查找选题
    List<Dati> findByStuID(Integer id) throws Exception;

    List<Dati> findByTeaID(Integer id) throws Exception;


}
