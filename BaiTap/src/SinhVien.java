import java.io.Serializable;

public class SinhVien implements Serializable {
        private String maSV, ten, lop;

        public SinhVien(String maSV, String ten, String lop) {
            this.maSV = maSV;
            this.ten = ten;
            this.lop = lop;
        }

        public String getMaSV() {
            return maSV;
        }

        public String getTen() {
            return ten;
        }

        public String getLop() {
            return lop;
        }

        public void setMaSV(String maSV) {
            this.maSV = maSV;
        }

        public void setTen(String ten) {
            this.ten = ten;
        }

        public void setLop(String lop) {
            this.lop = lop;
        }
        public String toString(){
            return this.ten + " " + this.maSV + " " + this.lop;
        }

}
