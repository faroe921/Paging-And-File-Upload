package com.msb.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Nino
 * @Date: 2024/6/13 - 06 - 13 - 上午11:14
 * @Description: com.msb.dao.impl
 * @version: 1.0
 */
public abstract class BaseDao {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/myhomework?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
    private static final String username = "root";
    private static final String password = "root";
    private Connection conn = null;

    public Connection getConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();// 异常处理
            throw new RuntimeException(e);
        }
        return conn;//返回连接对象
    }

    public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (null != pstmt) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List baseQuery(Class clazz, String sql, Object... args) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List list;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            rs = pstmt.executeQuery();
            list = new ArrayList();
            //getDeclaredFields();获取运行时类中的所有属性
            Field[] fields = clazz.getDeclaredFields();
            while (rs.next()) {
                //利用反射创建一个新的对象：
                Object o = clazz.newInstance();
                for (Field field : fields) {
                    //获取参数名
                    String fieldName = field.getName();
                    if (fieldName.equals("serialVersionUID")) {
                        continue;
                    }
                    //获取查询到的结果集中匹配参数名的value：
                    Object data = rs.getObject(fieldName);
                    //将参数名首字母大写，其余字母小写：
                    String setName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1).toLowerCase();
                    Method clazzMethod = clazz.getMethod("set" + setName, field.getType());
                    clazzMethod.invoke(o,data);
                }
                list.add(o);
            }
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeAll(conn, pstmt, rs);
        }
        return list;
    }

    public int baseQueryInt(String sql, Object... args) {
        int anInt = 0;
        PreparedStatement prepared = null;
        ResultSet resultSet = null;
        try {
            conn = getConnection();
            prepared = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                prepared.setObject(i + 1, args[i]);
            }
            resultSet = prepared.executeQuery();
            while (resultSet.next()) {
                anInt = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll(conn, prepared, resultSet);
        }
        return anInt;
    }
}
