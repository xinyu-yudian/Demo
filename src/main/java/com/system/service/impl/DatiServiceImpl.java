package com.system.service.impl;

import com.system.mapper.CollegeMapper;
import com.system.mapper.SelectedcourseMapper;
import com.system.mapper.DatiMapper;
import com.system.po.*;
import com.system.service.DatiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DatiServiceImpl implements DatiService {


    @Autowired
    private DatiMapper courseMapper;


    public void upadteById(Integer id, Dati courseCustom) throws Exception {
        courseMapper.updateByPrimaryKey(courseCustom);
    }




    public Boolean save(Dati couseCustom) throws Exception {

        return     courseMapper.insert(couseCustom)>0;

    }



    public Dati findById(Integer id) throws Exception {
        Dati course = courseMapper.selectByPrimaryKey(id);

        return course;
    }



    public List<Dati> findByStuID(Integer id) throws Exception {
        DatiExample courseExample = new DatiExample();
        //自定义查询条件
        DatiExample.Criteria criteria = courseExample.createCriteria();
        //根据教师id查选题
        criteria.andStuidEqualTo(id);
        List<Dati> list = courseMapper.selectByExample(courseExample);
        return list;
    }


    public List<Dati> findByTeaID(Integer id) throws Exception{

        List<Dati> list = courseMapper.selectdati(id);
        return list;
    }


}
