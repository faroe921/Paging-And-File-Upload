<%--
  Created by IntelliJ IDEA.
  User: faroe
  Date: 2024/7/30
  Time: 上午2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border: 1px red solid;
            margin: 0px auto;
            width: 80%;
        }

        td, th {
            border: 1px solid green;
        }
    </style>
    <script>
        function changePage(currentPage) {
            if (currentPage < 1) {
                alert("已经是第一页了")
                return;
            }
            if (currentPage >${pageBean.totalPage}) {
                alert("已经是最后一页了")
                return;
            }
            var ps = document.getElementById("pageSize");
            var stuName = document.getElementById("stuname");
            var stuname = stuName.value();
            var stuAge = document.getElementById("stuage");
            var stuage = stuAge.value();
            window.location.href = "showStudentController.do?stuname=" + stuname + "&stuage=" + stuage + "&currentPage=" + currentPage + "&pageSize=" + ps.value;
        }
    </script>
</head>
<body>
<div style="text-align: center">
    名字关键字:<input type="text" id="stuname" value="${stuname}">
    年龄下限<input type="text" id="stuage" value="${stuage}">
    <input type="button" value="查询" onclick="changePage(1)"><%--点击触发changePage方法页码自动变为1--%>
</div>
<table>
    <tr>
        <th>学生编号</th>
        <th>学生姓名</th>
        <th>学生年龄</th>
        <th>学生性别</th>
        <th>照片</th>
        <th>照片类型</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${pageBean.data}" var="student"><%--items:想要遍历的集合,var:循环中引用的变量名--%>
        <tr>
            <td>${student.stuid}</td>
            <td>${student.stuname}</td>
            <td>${student.stuage}</td>
            <td>${student.stugender}</td>
            <td>${student.filename}</td>
            <td>${student.filetype}</td>
            <td>
                <a href="#">下载</a><%--插入超链接--%>
            </td>
        </tr>
    </c:forEach>
    <tr align="center">
        <td colspan="7"><%--colspan:合并行，此处为添加一个7列宽的合并行--%>
            <input type="button" value="上一页" onclick="changePage(${pageBean.currentPage-1})">&nbsp;&nbsp;&nbsp;
            <%--在上一页按钮和下一页按钮中显示页码总数：--%>
            <c:forEach begin="1" var="num" end="${pageBean.totalPage}">
                <c:choose><%--判断:--%>
                    <c:when test="${num eq pageBean.currentPage}"><%--当num等于pageBean.currentPage时--%>
                        [${num}]<%--显示[]--%>
                    </c:when>
                    <c:otherwise><%--否则:--%>
                        ${num}
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <input type="button" value="下一页" onclick="changePage(${pageBean.currentPage+1})">&nbsp;&nbsp;&nbsp;
            <input type="button" value="尾页" onclick="changePage(${pageBean.totalPage})">&nbsp;&nbsp;&nbsp;
            每页<input id="pageSize" style="width: 30px" type="text" value="${pageBean.pageSize}">条&nbsp;&nbsp;&nbsp;
            当前第${pageBean.currentPage}页&nbsp;&nbsp;&nbsp;
            共[${pageBean.totalPage}]页&nbsp;&nbsp;&nbsp;
            共${pageBean.totalSize}条记录&nbsp;&nbsp;&nbsp;
        </td>
    </tr>
</table>
</body>
</html>