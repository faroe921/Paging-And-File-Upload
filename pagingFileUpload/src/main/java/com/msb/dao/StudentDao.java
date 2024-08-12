package com.msb.dao;

import com.msb.pojo.Student;

import java.util.List;

/**
 * @Auther: Nino
 * @Date: 2024/7/30 - 07 - 30 - 上午1:10
 * @Description: com.msb.dao
 * @version: 1.0
 */
public interface StudentDao {

    List<Student> findByPage(String stuname, String stuage, Integer currentPage, Integer pageSize);

    int findTotalSize(String stuname, String stuage);
}
