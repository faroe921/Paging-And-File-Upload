package com.msb.service.impl;

import com.msb.dao.StudentDao;
import com.msb.dao.impl.StudentDaoImpl;
import com.msb.pojo.PageBean;
import com.msb.pojo.Student;
import com.msb.service.StudentService;

import java.util.List;

/**
 * @Auther: Nino
 * @Date: 2024/7/30 - 07 - 30 - 上午1:09
 * @Description: com.msb.service.impl
 * @version: 1.0
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public PageBean<Student> findByPage(String stuname, String stuage, Integer currentPage, Integer pageSize) {
        List<Student> students = studentDao.findByPage(stuname, stuage, currentPage, pageSize);
        int totalSize = studentDao.findTotalSize(stuname, stuage);
        int totalPage = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
        PageBean<Student> pageBean = new PageBean<Student>(students, pageSize, currentPage, totalPage, totalSize);
        return pageBean;
    }
}