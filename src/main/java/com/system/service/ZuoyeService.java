package com.system.service;

import com.system.po.Zuoye;

import java.util.List;

/**
 * ZuoyeService选题信息.
 */
public interface ZuoyeService {
    //根据id更新选题信息
    void upadteById(Integer id, Zuoye course) throws Exception;


    //插入选题信息
    Boolean save(Zuoye couseCustom) throws Exception;


    //根据id查询
    Zuoye findById(Integer id) throws Exception;


    //根据学生id查找选题
    List<Zuoye> findByteaID(Integer id) throws Exception;


    //根据学生id查找选题
    List<Zuoye> findList() throws Exception;


}
