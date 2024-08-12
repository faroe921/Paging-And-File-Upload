package com.msb.pojo;

import java.io.Serializable;

/**
 * @Auther: Nino
 * @Date: 2024/7/30 - 07 - 30 - 上午12:45
 * @Description: com.msb.pojo
 * @version: 1.0
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer stuid;
    private String stuname;
    private Integer stuage;
    private String stugender;
    private String filename;
    private String filetype;

    public Student() {
    }

    public Student(Integer stuid, String stuname, Integer stuage, String stugender, String filename, String filetype) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.stuage = stuage;
        this.stugender = stugender;
        this.filename = filename;
        this.filetype = filetype;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public Integer getStuage() {
        return stuage;
    }

    public void setStuage(Integer stuage) {
        this.stuage = stuage;
    }

    public String getStugender() {
        return stugender;
    }

    public void setStugender(String stugender) {
        this.stugender = stugender;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuid=" + stuid +
                ", stuname='" + stuname + '\'' +
                ", stuage=" + stuage +
                ", stugender='" + stugender + '\'' +
                ", filename='" + filename + '\'' +
                ", filetype='" + filetype + '\'' +
                '}';
    }
}