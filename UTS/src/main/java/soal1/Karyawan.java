package soal1;

//Saya memakai library pengelolaan date agar lebih rapi dan terstruktur
import java.time.LocalDate;

//superclass
public class Karyawan {
    private String ID;
    private String nama;
    private String posisi;
    private double gaji;
    //tanggalbergabung memakai tipe data local date sehingga nanti bisa dihitung secara otomatis utk durasi bekerja
    private LocalDate tanggalBergabung;
    private String divisi;

    //constructor
    public Karyawan(String ID, String nama, String posisi, double gaji, LocalDate tanggalBergabung, String divisi) {
        this.ID = ID;
        this.nama = nama;
        this.posisi = posisi;
        this.gaji = gaji;
        this.tanggalBergabung = tanggalBergabung;
        this.divisi = divisi;
    }

    //getter
    public String getID() {
        return ID;
    }

    public String getNama() {
        return nama;
    }

    public String getPosisi() {
        return posisi;
    }

    public double getGaji() {
        return gaji;
    }

    public LocalDate getTanggalBergabung() {
        return tanggalBergabung;
    }

    public String getDivisi() {
        return divisi;
    }

    //setter
    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }
}