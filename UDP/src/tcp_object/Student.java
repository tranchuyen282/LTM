package tcp_object;
/*
 * @author Tran Chuyen
 */

import java.io.Serializable;
import java.util.*;
import java.lang.*;

public class Student implements Serializable{
    private static final long serialVersionUID = 20151107;
    private int id;
    private String code;
    private float gpa;
    private String gpaletter;

    public Student() {
    }

    public Student(int id, String code, float gpa, String gpaletter) {
        this.id = id;
        this.code = code;
        this.gpa = gpa;
        this.gpaletter = gpaletter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getGpaletter() {
        return gpaletter;
    }

    public void setGpaletter(String gpaletter) {
        this.gpaletter = gpaletter;
    }
    
    
    
}
