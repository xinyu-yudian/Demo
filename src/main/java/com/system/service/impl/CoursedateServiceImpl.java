package com.system.service.impl;

import com.system.mapper.*;
import com.system.po.*;
import com.system.service.CourseService;
import com.system.service.CoursedateService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CoursedateServiceImpl implements CoursedateService {

    @Autowired
    private CoursedateMapper coursedateMapper;


    //插入课程信息
   public Boolean save(Coursedate couseCustom) throws Exception{
     return   coursedateMapper.insert(couseCustom)>0;
   }

   public Coursedate selectnew(){
       return coursedateMapper.selectnew();
   }
}
