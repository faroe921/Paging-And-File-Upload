package com.msb.controller;

import com.msb.pojo.PageBean;


import com.msb.pojo.Student;
import com.msb.service.StudentService;
import com.msb.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: Nino
 * @Date: 2024/7/30 - 07 - 30 - 上午12:50
 * @Description: com.msb.controller
 * @version: 1.0
 */
@WebServlet(urlPatterns = "/showStudentController.do")
public class ShowStudentController extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收数据
        Integer currentPage = Integer.parseInt(req.getParameter("currentPage"));
        Integer pageSize = Integer.parseInt(req.getParameter("pageSize"));
        String stuname = req.getParameter("stuname");
        String stuage = req.getParameter("stuage");
        // 调用service层服务处理业务逻辑
        PageBean<Student> pageBean = studentService.findByPage(stuname,stuage,currentPage, pageSize);
        // 响应数据,页面跳转
        req.setAttribute("pageBean", pageBean);
        req.getRequestDispatcher("showStudent.jsp").forward(req, resp);
    }
}
