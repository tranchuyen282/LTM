package RMI1;
/*
 * @author Tran Chuyen
 */

import java.io.Serializable;
import java.util.*;
import java.lang.*;

public class Product implements Serializable{
    private static final long serialVersionUID = 20151107;
    public int id;
    public String code;
    public String name;
    public float ImportPrice;
    public float ExportPrice;
    public String createdUser;

    public Product() {
    }

    
    public Product(int id, String code, String name, float ImportPrice, float ExportPrice, String createdUser) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.ImportPrice = ImportPrice;
        this.ExportPrice = ExportPrice;
        this.createdUser = createdUser;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getImportPrice() {
        return ImportPrice;
    }

    public void setImportPrice(float ImportPrice) {
        this.ImportPrice = ImportPrice;
    }

    public float getExportPrice() {
        return ExportPrice;
    }

    public void setExportPrice(float ExportPrice) {
        this.ExportPrice = ExportPrice;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }
    
    
    
    
    
}
