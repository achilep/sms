/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edufet.sms.service;

import com.edufet.sms.model.Teacherinfo;
import org.springframework.stereotype.Service;


@Service
public interface TeacherinfoService {

    public String insertTeacher(Teacherinfo teacher);

    public String updateTeacher(int teacher_id, Teacherinfo teacher);

    public String deleteTeacher(int teacher_id);

    public String viewTeacher();

    public Teacherinfo viewOneTeacher(int teacher_id);
    
    public Teacherinfo showOneTeacherbyEmail(String email);

}
