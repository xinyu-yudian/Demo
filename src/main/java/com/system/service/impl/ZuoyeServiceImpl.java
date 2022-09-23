package com.system.service.impl;

import com.system.mapper.ZuoyeMapper;
import com.system.po.Zuoye;
import com.system.po.ZuoyeExample;
import com.system.service.ZuoyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ZuoyeServiceImpl implements ZuoyeService {


    @Autowired
    private ZuoyeMapper courseMapper;


    public void upadteById(Integer id, Zuoye courseCustom) throws Exception {
        courseMapper.updateByPrimaryKey(courseCustom);
    }




    public Boolean save(Zuoye couseCustom) throws Exception {

        return     courseMapper.insert(couseCustom)>0;

    }



    public Zuoye findById(Integer id) throws Exception {
        Zuoye course = courseMapper.selectByPrimaryKey(id);

        return course;
    }



    public List<Zuoye> findByteaID(Integer id) throws Exception {
        ZuoyeExample courseExample = new ZuoyeExample();
        //自定义查询条件
        ZuoyeExample.Criteria criteria = courseExample.createCriteria();
        //根据教师id查选题
        criteria.andTeaidEqualTo(id);
        List<Zuoye> list = courseMapper.selectByExample(courseExample);
        return list;
    }

    public List<Zuoye> findList() throws Exception{
        ZuoyeExample courseExample = new ZuoyeExample();
        //自定义查询条件
        ZuoyeExample.Criteria criteria = courseExample.createCriteria();
        List<Zuoye> list = courseMapper.selectByExample(courseExample);
        return list;
    }


}
