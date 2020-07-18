/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edufet.sms.controller;

import com.edufet.sms.service.AcademicyearService;
import com.edufet.sms.service.ClassnameService;
import com.edufet.sms.service.ClasssectionService;
import com.edufet.sms.service.ExaminfoService;
import com.edufet.sms.service.ExammarkService;
import com.edufet.sms.service.GuardianService;
import com.edufet.sms.service.NoticeService;
import com.edufet.sms.service.StgroupService;
import com.edufet.sms.service.StudentattendanceService;
import com.edufet.sms.service.StudentinfoService;
import com.edufet.sms.service.StudentregistrationService;
import com.edufet.sms.service.SubjectService;
import com.edufet.sms.service.TeacherinfoService;
import com.edufet.sms.model.Classname;
import com.edufet.sms.model.Examinfo;
import com.edufet.sms.model.Exammark;
import com.edufet.sms.model.Guardian;
import com.edufet.sms.model.Notice;
import com.edufet.sms.model.Stgroup;
import com.edufet.sms.model.Studentattendance;
import com.edufet.sms.model.Studentinfo;
import com.edufet.sms.model.Teacherinfo;
import com.google.gson.Gson;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TeacherinfoCtrl {

    @Autowired
    TeacherinfoService teacher;

    @Autowired
    private ServletContext servletContext;
    
    @Autowired
    StudentattendanceService atten;
    
    @Autowired
    ClassnameService subc;

    @Autowired
    StudentregistrationService streg;

    
    @Autowired
    StudentinfoService stis;
    
    
    @Autowired
    GuardianService gs;
    
    @Autowired
    StudentinfoService ss;
    
    @Autowired
    ExammarkService exmark;

    @Autowired
    StudentinfoService stinfo;

    @Autowired
    StgroupService stgroup;

    @Autowired
    AcademicyearService year;

    @Autowired
    SubjectService sub;

    @Autowired
    ExaminfoService subE;
    
    @Autowired
    ClassnameService classser;

    @Autowired
    ClasssectionService classsec;

    @Autowired
    StudentregistrationService sts;
    
    @Autowired
    ExaminfoService exms;
    
    @Autowired
    NoticeService subnotice;

    @Autowired
    StgroupService sowgroup;

    
    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, "tjoindate", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }

    @RequestMapping("/showteacherpage")
    public ModelAndView showteacherpage() {
        String teacherlist = teacher.viewTeacher();
        String sublist = sub.viewSubject();
        ModelAndView mv = new ModelAndView("admin/teacherinfo", "newTeacherObject", new Teacherinfo());
        mv.addObject("teacherlist", teacherlist);
        mv.addObject("sublist", sublist);
        mv.addObject("check", "true");
        return mv;
    }
    

    @RequestMapping("/showteacherpage2")
    public ModelAndView showteacherpage2() {
        String teacherlist = teacher.viewTeacher();
        String sublist = sub.viewSubject();
        ModelAndView mv = new ModelAndView("student/teacherinfo", "newTeacherObject", new Teacherinfo());
        mv.addObject("teacherlist", teacherlist);
        mv.addObject("sublist", sublist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/showteacherpage1")
    public ModelAndView showteacherpage1() {
        String teacherlist = teacher.viewTeacher();
        String sublist = sub.viewSubject();
        ModelAndView mv = new ModelAndView("student/teacherinfo", "newTeacherObject", new Teacherinfo());
        mv.addObject("teacherlist", teacherlist);
        mv.addObject("sublist", sublist);
        mv.addObject("check", "true");
        return mv;
    }

    
    @RequestMapping("/showteacher")
    public ModelAndView showteacherlist() {
        String tlist = teacher.viewTeacher();
        ModelAndView mv = new ModelAndView("admin/teacherlist");
        mv.addObject("tList", tlist);
        return mv;
    }
    
    

    @RequestMapping(value = "/teacheradd", params = "Add")
    public String addteacher(@ModelAttribute("newTeacherObject") Teacherinfo t, HttpServletRequest request) {
        teacher.insertTeacher(t);
        String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        //String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcuts = targetcut.substring(0, targetcut.lastIndexOf("\\"));
        //System.out.println(targetcut+".......");
        //System.out.println(request.getSession().getServletContext());
        //String p = servletContext.getContextPath();
        String p = targetcuts + "\\src\\main\\webapp\\resources\\timage\\" + String.valueOf(t.getTid()) + "" + ".jpg";
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";

        MultipartFile filedet = t.getTimage();
        if (!filedet.isEmpty()) {
            try {
                byte[] bytes = filedet.getBytes();

                FileOutputStream fos = new FileOutputStream(new File(p));
                BufferedOutputStream bs = new BufferedOutputStream(fos);
                bs.write(bytes);
                bs.close();
                fos.close();
                Thread.sleep(10000);
                System.out.println("File Uploaded Successfully");
            } catch (Exception e) {
                System.out.println("Exception Arised" + e);
            }
        } else {
            System.out.println("File is Empty not Uploaded");
        }

        return "redirect:/showteacherpage";
    }

    @RequestMapping(value = "/teacheradd", params = "Edit")
    public String editteacherr(@ModelAttribute("newTeacherObject") Teacherinfo t, HttpServletRequest request) {
        teacher.updateTeacher(t.getTid(), t);

        String path = servletContext.getRealPath("/");

        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        //String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcuts = targetcut.substring(0, targetcut.lastIndexOf("\\"));
        //System.out.println(targetcut+".......");
        //System.out.println(request.getSession().getServletContext());
        //String p = servletContext.getContextPath();
        String p = targetcuts + "\\src\\main\\webapp\\resources\\timage\\" + String.valueOf(t.getTid()) + "" + ".jpg";
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";

        MultipartFile filedet = t.getTimage();
        if (!filedet.isEmpty()) {
            try {
                byte[] bytes = filedet.getBytes();
                System.out.println(bytes.length);
                FileOutputStream fos = new FileOutputStream(new File(p));
                BufferedOutputStream bs = new BufferedOutputStream(fos);
                bs.write(bytes);
                bs.close();
                fos.close();
                Thread.sleep(10000);
                System.out.println("File Uploaded Successfully");
            } catch (Exception e) {
                System.out.println("Exception Arised" + e);
            }
        } else {
            System.out.println("File is Empty not Uploaded");
        }
        return "redirect:/showteacherpage";
    }

    @RequestMapping("removingteacher/{tid}")
    public String removeteacher(@PathVariable("tid") int teacherid) {
        teacher.deleteTeacher(teacherid);
        return "redirect:/showteacherpage";
    }

    @RequestMapping("/viewteacher")
    public ModelAndView viewteacher(@RequestParam("getId") int teacherid, HttpSession session) {
        Gson g = new Gson();
        String teacherinfo = g.toJson(teacher.viewOneTeacher(teacherid));
        //session.setAttribute("productid", productid);
        ModelAndView mv = new ModelAndView("description");
        mv.addObject("oneteacher", teacherinfo);
        return mv;
    }

    @RequestMapping("/teacherpage")
    public ModelAndView viewviewteacherlist() {
        String teacherlist = teacher.viewTeacher();
        ModelAndView mv = new ModelAndView("viewteacher");
        mv.addObject("teacherlist", teacherlist);
        return mv;
    }

    @RequestMapping("/editingteacher")
    public ModelAndView editoneteacher(@RequestParam("gettid") int tid) {
        String teacherlist = teacher.viewTeacher();
        String sublist = sub.viewSubject();
        ModelAndView mv = new ModelAndView("admin/teacherinfo", "newTeacherObject", teacher.viewOneTeacher(tid));
        mv.addObject("teacherlist", teacherlist);
        mv.addObject("sublist", sublist);
        mv.addObject("check", "false");
        return mv;
    }
    
    @RequestMapping("/teacherprofilelink")
    public ModelAndView showingTeacher(@RequestParam("gettid") int tid) {
        Teacherinfo singlet = teacher.viewOneTeacher(tid);
        System.out.println(singlet);
        Gson g = new Gson();
        String singleTJson = g.toJson(singlet);
        ModelAndView mv = new ModelAndView("admin/teacherprofile", "tprofileObj", singlet);
        mv.addObject("singleT", singleTJson);
        return mv;
    }
    
    @RequestMapping("/tprofilelink")
    public ModelAndView showingmyProfile(@RequestParam("gettid") int tid) {
        Teacherinfo singlet = teacher.viewOneTeacher(tid);
        System.out.println(singlet);
        Gson g = new Gson();
        String singleTJson = g.toJson(singlet);
        ModelAndView mv = new ModelAndView("teacher/teacherprofile", "tprofileObj", singlet);
        mv.addObject("singleT", singleTJson);
        return mv;
    }
    @RequestMapping("/showexammarkpageytecaher")
    public ModelAndView showmarkpage() {
        String marklist = exmark.viewExammark();
        String studentlist = stinfo.viewstudent();
        String grouplist = stgroup.viewStgroup();
        String yearlist = year.viewAcademicyear();
        String subjectlist = sub.viewSubject();
        String classlist = classser.viewClassname();
        String sectionlist = classsec.viewClasssection();
        String examlist = exms.viewExaminfo();
        ModelAndView mv = new ModelAndView("teacher/exammark", "exammarkObject", new Exammark());
        mv.addObject("marklist", marklist);
        mv.addObject("studentlist", studentlist);
        mv.addObject("grouplist", grouplist);
        mv.addObject("yearlist", yearlist);
        mv.addObject("subjectlist", subjectlist);
        mv.addObject("classlist", classlist);
        mv.addObject("sectionlist", sectionlist);
        mv.addObject("examlist", examlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/showingexaminfoteacherpage")
    public ModelAndView showsubjectpage() {
        String subgsonlist = subE.viewExaminfo();
        ModelAndView mv = new ModelAndView("teacher/examinfo", "addExaminfoObject1", new Examinfo());
        mv.addObject("examinfomodelobject", subgsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    @RequestMapping("/studentinfoepagefromteacher")
    public ModelAndView showteacherpageforstudent() {
        String studentlist = stis.viewstudent();

        ModelAndView mv = new ModelAndView("teacher/studentinfo", "addStuObject1", new Studentinfo());
        mv.addObject("studentlists", studentlist);

        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/attendencpageforteacher")
    public ModelAndView showteacherattendancepage() {
        String attendencelist = atten.viewattendenc();
        String studentlist = stinfo.viewstudent();
        String streglist = streg.viewStudentregistration();
        String classlist = classser.viewClassname();
        String grouplist = stgroup.viewStgroup();
        String sectiontlist = classsec.viewClasssection();
        ModelAndView mv = new ModelAndView("teacher/attendence", "attendenceObject", new Studentattendance());
        mv.addObject("attendencelists", attendencelist);
        mv.addObject("studentlists", studentlist);
        mv.addObject("streglists", streglist);
        mv.addObject("classlists", classlist);
        mv.addObject("grouplists", grouplist);
        mv.addObject("sectiontlists", sectiontlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/showingclassnamefromteacherpage")
    public ModelAndView showsubjecttpage() {
        String subgsonlist = subc.viewClassname();
        ModelAndView mv = new ModelAndView("teacher/classname", "addClassnameObject1", new Classname());
        mv.addObject("classnamemodelobject", subgsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping("/showingnoticetoteacherpage")
    public ModelAndView showsubjectteacherpage() {
        String subgsonlist = subnotice.viewNotice();
        ModelAndView mv = new ModelAndView("teacher/notice", "addNoticeObject1", new Notice());
        mv.addObject("noticemodelobject", subgsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    @RequestMapping("/showguardianfromteacherpage")
    public ModelAndView showguardianpage() {
        String guardian = gs.viewGuardian();
        String student = ss.viewstudent();
        ModelAndView mv = new ModelAndView("teacher/guardian", "addGuardianObject", new Guardian());
        mv.addObject("guardianList",guardian);
        mv.addObject("studentList",student);
        mv.addObject("check", "true");
        return mv;
    }
    

    @RequestMapping("/showingstgrouppagefromteacher")
    public ModelAndView showsubjectteachepage() {
        String subgsonlist = sowgroup.viewStgroup();
        ModelAndView mv = new ModelAndView("teacher/stgroup", "addStgroupObject1", new Stgroup());
        mv.addObject("stgroupmodelobject", subgsonlist);
        mv.addObject("check", "true");
        return mv;
    }

}
