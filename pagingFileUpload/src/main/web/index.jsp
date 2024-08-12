<%--
  Created by IntelliJ IDEA.
  User: faroe
  Date: 2024/7/30
  Time: 上午5:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="showStudentController.do" method="get">
    <table>
        <tr>
            <td>您想查询的第几页：</td>
            <td><input type="text" name="currentPage"></td>
        </tr>
        <tr>
            <td>您希望一页显示几行信息：</td>
            <td><input type="text" name="pageSize"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
