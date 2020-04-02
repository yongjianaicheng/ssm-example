package com.example.service;

import com.example.beans.Teacher;
import com.example.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    public Teacher getTeacher(Integer id){
        Teacher teacher = teacherDao.getTeacherById(1);
        return teacher;
    }
}
