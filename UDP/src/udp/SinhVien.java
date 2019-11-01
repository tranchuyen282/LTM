package udp;
/*
 * @author Tran Chuyen
 */

import java.io.Serializable;
import java.util.*;
import java.lang.*;

public class SinhVien implements Serializable{
    private static final long serialVersionUID = 20151107;
    private int id;
    private String code;
    private float gpa;
    private String gpaLetter;

    public SinhVien(int id, String code,float gpa, String gpaLetter) {
        this.id = id;
        this.code = code;
        this.gpa = gpa;
        this.gpaLetter = gpaLetter;
    }

    public SinhVien(String code) {
        this.code = code;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpaLetter(String gpaLetter) {
        this.gpaLetter = gpaLetter;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "id=" + id + ", code=" + code + ", gpa=" + gpa + ", gpaLetter=" + gpaLetter + '}';
    }
    
    
}
