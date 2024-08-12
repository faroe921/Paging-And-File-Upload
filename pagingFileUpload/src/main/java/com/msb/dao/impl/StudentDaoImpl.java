package com.msb.dao.impl;

import com.msb.dao.StudentDao;
import com.msb.pojo.PageBean;
import com.msb.pojo.Student;
import com.sun.org.apache.bcel.internal.util.Args;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: Nino
 * @Date: 2024/7/30 - 07 - 30 - 上午1:10
 * @Description: com.msb.dao.impl
 * @version: 1.0
 */
public class StudentDaoImpl extends BaseDao implements StudentDao {

    @Override
    public List<Student> findByPage(String stuname, String stuage, Integer currentPage, Integer pageSize) {
        List students;
        StringBuffer sql = new StringBuffer("select * from student where 1=1");
        if (null != stuname && "".equals(stuname)) {
            sql.append("and stuname like ?");
        }
        if (null != stuage && "".equals(stuage)) {
            sql.append("and stuage > ?");
        }
        sql.append("limit ?,?");
        if (null != stuname && !"".equals(stuname) && null != stuage && !"".equals(stuage)) {
            students = baseQuery(Student.class, sql.toString(), stuname, stuage, (currentPage - 1) * pageSize, pageSize);
        } else if (null != stuname && !"".equals(stuname) && (null == stuage || "".equals(stuage))) {
            students = baseQuery(Student.class, sql.toString(), stuname, (currentPage - 1) * pageSize, pageSize);
        } else if ((null == stuname || "".equals(stuname)) && null != stuage && !"".equals(stuage)) {
            students = baseQuery(Student.class, sql.toString(), stuage, (currentPage - 1) * pageSize, pageSize);
        }else {
            students = baseQuery(Student.class, sql.toString(), (currentPage - 1) * pageSize, pageSize);
        }
        return students;
    }

    @Override
    public int findTotalSize(String stuname, String stuage) {
        String sql = "select count(*) from student;";
        int count = baseQueryInt(sql);
        return count;
    }
}
