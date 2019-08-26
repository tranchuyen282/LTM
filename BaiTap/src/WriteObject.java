import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteObject {
    public static ArrayList<SinhVien> readObject(){
        ArrayList<SinhVien> list = new ArrayList<SinhVien>();
        try{
            File fl = new File("sinhvien.txt");
            FileInputStream file = new FileInputStream(fl);
            ObjectInputStream in = new ObjectInputStream(file);
            Object obj = null;
            while((obj = in.readObject()) != null){
                SinhVien s = (SinhVien)obj;
                list.add(s);
            }
            in.close();
        } catch(Exception ex){

        }

        return list;
    }

    public static void writeObject(ArrayList<SinhVien> list){
        try{
            File fl = new File("sinhvien.txt");
            FileOutputStream file1 = new FileOutputStream(fl);
            ObjectOutputStream os = new ObjectOutputStream(file1);
            for(SinhVien s:list){
                os.writeObject(s);
            }
            os.close();

        }catch(Exception e){

        }
    }

    public static void main(String[] args) {
        ArrayList<SinhVien> list = new ArrayList<SinhVien>();
        File file = new File("sinhvien.txt");
        int sizeFile = (int) file.length();
        if(sizeFile == 0){
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap 5 sinh vien khoi tao: ");
            for(int i = 1; i <= 5; i++){
                System.out.println("Nhap ten sv, ma, lop lan luot:");
                String ten = sc.nextLine();
                String ma = sc.nextLine();
                String lop = sc.nextLine();
                SinhVien sinhVien = new SinhVien(ma,ten,lop);
                list.add(sinhVien);
            }
            System.out.println("ghi vao file");
            writeObject(list);
        }else{
            //doc file
            list = readObject();
            for (SinhVien s: list){
                System.out.println(s);
            }
        }




    }

}
