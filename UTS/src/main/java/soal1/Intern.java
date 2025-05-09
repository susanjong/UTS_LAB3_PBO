package soal1;

import java.time.LocalDate;

//subclass
public class Intern extends Karyawan {
    private String universitas;
    private int durasiMagangBulan;

    //constructor
    public Intern(String ID, String nama, String posisi, double gaji, LocalDate tanggalBergabung, String divisi, String universitas, int durasiMagangBulan) {
        super(ID, nama, posisi, gaji, tanggalBergabung, divisi);
        this.universitas = universitas;
        this.durasiMagangBulan = durasiMagangBulan;
    }

    //getter
    public String getUniversitas() {
        return universitas;
    }

    //setter
    public int getDurasiMagangBulan() {
        return durasiMagangBulan;
    }
}
