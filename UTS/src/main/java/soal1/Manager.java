package soal1;

import java.time.LocalDate;

//subclass
public class Manager extends Karyawan {
    private double bonus;

    //constructor
    public Manager(String ID, String nama, String posisi, double gaji, LocalDate tanggalBergabung, String divisi, double bonus) {
        super(ID, nama, posisi, gaji, tanggalBergabung, divisi);
        this.bonus = bonus;
    }

    //getter
    public double getBonus() {
        return bonus;
    }

    //setter
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    //method overloading
    public double totalGaji(boolean bool) {
        if (bool) {
            return getGaji() + bonus;
        } else {
            return getGaji();
        }
    }
}
