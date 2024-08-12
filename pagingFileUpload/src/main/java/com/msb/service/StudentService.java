package com.msb.service;

import com.msb.pojo.PageBean;
import com.msb.pojo.Student;

/**
 * @Auther: Nino
 * @Date: 2024/7/30 - 07 - 30 - 上午1:09
 * @Description: com.msb.service
 * @version: 1.0
 */
public interface StudentService {
    PageBean<Student> findByPage(String stuname, String stuage,Integer currentPage, Integer pageSize);
}
