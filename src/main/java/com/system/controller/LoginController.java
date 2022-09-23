package com.system.controller;

import com.system.po.Coursedate;
import com.system.po.Userlogin;
import com.system.service.CoursedateService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class LoginController {

    @Autowired
    private CoursedateService coursedateService;

    //登录跳转
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String loginUI() throws Exception {
        return "../../login";
    }

    //登录表单处理
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String login(Userlogin userlogin, Model model, HttpSession session) throws Exception {

        //Shiro实现登录
        UsernamePasswordToken token = new UsernamePasswordToken(userlogin.getUsername(),
                userlogin.getPassword());
        Subject subject = SecurityUtils.getSubject();

        //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
        subject.login(token);

        if (subject.hasRole("admin")) {
            return "redirect:/admin/showStudent";
        } else if (subject.hasRole("teacher")) {
            return "redirect:/teacher/showCourse";
        } else if (subject.hasRole("student")) {
            Date date = new Date();
          // DateFormat的格式（即yyyy/MM/dd HH:mm:ss）就是将获得日期字符串显示的格式
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
            String nowDateStr = sdf.format(date);
            Coursedate coursedate= coursedateService.selectnew();
            if(coursedate==null){
                session.setAttribute("cdate",null);
            }else if(sdf.parse(coursedate.getEndtime()).after(date)){
                session.setAttribute("cdate",coursedate);
            }else{
                session.setAttribute("cdate",null);
            }
            return "redirect:/student/showCourse";
        }

        return "/login";
    }

}
