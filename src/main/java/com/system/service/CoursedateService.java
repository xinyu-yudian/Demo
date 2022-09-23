package com.system.service;

import com.system.po.CourseCustom;
import com.system.po.Coursedate;

import java.util.List;


public interface CoursedateService {


    //插入课程信息
    Boolean save(Coursedate couseCustom) throws Exception;

    Coursedate selectnew();
}
