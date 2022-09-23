package com.system.controller;

import com.system.exception.CustomException;
import com.system.po.*;
import com.system.service.*;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @Resource(name = "studentServiceImpl")
    private StudentService studentService;

    @Resource(name = "selectedCourseServiceImpl")
    private SelectedCourseService selectedCourseService;

    @Resource(name = "coursedateServiceImpl")
    private CoursedateService coursedateService;

    @Resource(name = "datiServiceImpl")
    private DatiService datiService;


    @Resource(name = "zuoyeServiceImpl")
    private ZuoyeService ZuoyeService;


    @RequestMapping(value = "/showCourse")
    public String stuCourseShow(Model model, Integer page) throws Exception {

        List<CourseCustom> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(courseService.getCountCouse());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = courseService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = courseService.findByPaging(page);
        }
        for(CourseCustom courseCustom:list){
            courseCustom.setNopeople(courseCustom.getPeople()-selectedCourseService.countByCourseID(courseCustom.getCourseid()));
            courseCustom.setHaspeople(selectedCourseService.countByCourseID(courseCustom.getCourseid()));
        }





        Date date = new Date();
        // DateFormat的格式（即yyyy/MM/dd HH:mm:ss）就是将获得日期字符串显示的格式
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDateStr = sdf.format(date);
        Coursedate coursedate= coursedateService.selectnew();
        if(coursedate==null){
            model.addAttribute("cda",null);
        }else if(sdf.parse(coursedate.getEndtime()).after(date)&& sdf.parse(coursedate.getStarttime()).before(date)){
            model.addAttribute("cda",coursedate);
        }else{
            model.addAttribute("cda",null);
        }
        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
      //  StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String) subject.getPrincipal());
if(coursedate!=null) {
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("starttime", coursedate.getStarttime());
    map.put("endtime", coursedate.getEndtime());
    map.put("studentID", (String) subject.getPrincipal());
    if(selectedCourseService.count(map)>0){
        model.addAttribute("count", 1);
    }
    if(selectedCourseService.count(map)==0){
        model.addAttribute("count", 0);
    }

}else{
    model.addAttribute("count", 2);
}

      /*  List<SelectedCourseCustom> list1 = studentCustom.getSelectedCourseList();

        if(list1.size()>0){
            model.addAttribute("count", 1);
        }else{
            model.addAttribute("count", 0);
        }
*/
        model.addAttribute("courseList", list);
        model.addAttribute("pagingVO", pagingVO);

        return "student/showCourse";
    }

    // 选课操作
    @RequestMapping(value = "/stuSelectedCourse")
    public String stuSelectedCourse(int id) throws Exception {


        Date date = new Date();
        // DateFormat的格式（即yyyy/MM/dd HH:mm:ss）就是将获得日期字符串显示的格式
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDateStr = sdf.format(date);
        Coursedate coursedate= coursedateService.selectnew();
        if(coursedate==null){
            throw new CustomException("选课时间未定");
        }else if(sdf.parse(coursedate.getEndtime()).after(date)&& sdf.parse(coursedate.getStarttime()).before(date)){

        }else{
            throw new CustomException("选课时间未开始或已结束");
        }

        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
        selectedCourseCustom.setCourseid(id);
        selectedCourseCustom.setStudentid(Integer.parseInt(username));

        SelectedCourseCustom s = selectedCourseService.findOne(selectedCourseCustom);
        int count=selectedCourseService.countByCourseID(id);
       int people= courseService.findById(id).getPeople();
       selectedCourseCustom.setCoursedate(nowDateStr);
       if(people<=count){
           throw new CustomException("该门课程学生已经满了，请选择别的课程");
       }
        if (s == null) {
            selectedCourseService.save(selectedCourseCustom);
        } else {
            throw new CustomException("该门课程你已经选了，不能再选");
        }

        return "redirect:/student/selectedCourse";
    }

    // 退课操作
    @RequestMapping(value = "/outCourse")
    public String outCourse(int id) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
        selectedCourseCustom.setCourseid(id);
        selectedCourseCustom.setStudentid(Integer.parseInt(username));

        selectedCourseService.remove(selectedCourseCustom);

        return "redirect:/student/selectedCourse";
    }

    // 已选课程
    @RequestMapping(value = "/selectedCourse")
    public String selectedCourse(Model model) throws Exception {
        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String) subject.getPrincipal());
        List<SelectedCourseCustom> list=null;
        if(studentCustom!=null){
    list = studentCustom.getSelectedCourseList();
}

        Date date = new Date();
        // DateFormat的格式（即yyyy/MM/dd HH:mm:ss）就是将获得日期字符串显示的格式
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDateStr = sdf.format(date);
        Coursedate coursedate= coursedateService.selectnew();
        if(coursedate==null){
            model.addAttribute("cda",null);
        }else if(sdf.parse(coursedate.getEndtime()).after(date)&& sdf.parse(coursedate.getStarttime()).before(date)){
            model.addAttribute("cda",coursedate);
        }else{
            model.addAttribute("cda",null);
        }

        model.addAttribute("selectedCourseList", list);

        return "student/selectCourse";
    }

    // 已修课程
    @RequestMapping(value = "/overCourse")
    public String overCourse(Model model) throws Exception {

        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String) subject.getPrincipal());
        List<SelectedCourseCustom> list=null;
        if(studentCustom!=null){
            list = studentCustom.getSelectedCourseList();
        }


        model.addAttribute("selectedCourseList", list);

        return "student/overCourse";
    }

    //修改密码
    @RequestMapping(value = "/passwordRest")
    public String passwordRest() throws Exception {
        return "student/passwordRest";
    }


    @RequestMapping(value = "/addzuoyepage")
    public String addzuoyepage(Model model) throws Exception {

        List<Zuoye> list=ZuoyeService.findList();
        model.addAttribute("zuoye", list);

        return "student/adddati";
    }


    @RequestMapping(value = "/showdatistu")
    public String showdatistu(Model model) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String) subject.getPrincipal());
        List<Dati> list=datiService.findByStuID(studentCustom.getUserid());
        model.addAttribute("dati", list);

        return "student/showdati";
    }



    @RequestMapping(value="/uploadzuoda",method= RequestMethod.POST)
    public String uploadlunwen(HttpServletRequest request,
                               int zuoyeid,
                               MultipartFile file,
                               String bz) throws Exception {
        Date date = new Date();
        // DateFormat的格式（即yyyy/MM/dd HH:mm:ss）就是将获得日期字符串显示的格式
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDateStr = sdf.format(date);
        Dati dati=new Dati();
        dati.setRiqi(nowDateStr);
        dati.setZuoyeid(zuoyeid);
        dati.setBz(bz);
        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String) subject.getPrincipal());
        //如果文件不为空，写入上传路径
        dati.setStuid(studentCustom.getUserid());
        if(!file.isEmpty()) {
            //上传文件路径
            String path = request.getServletContext().getRealPath("/images/");
            //上传文件名
            String filename = file.getOriginalFilename();
            dati.setFilename(filename);
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            datiService.save (dati);
            return "redirect:/student/showdatistu";
        } else {
            return "error";
        }



    }

    @RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename,
                                           Model model)throws Exception {
        //下载文件路径
        String path = request.getServletContext().getRealPath("/images/");
        File file = new File(path + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

}
