package soal2;

import java.util.ArrayList;

public class ProgramParkir {
    private final ArrayList<KendaraanUmum> dataKendaraan = new ArrayList<>();

    public void inputManual(KendaraanUmum item, int waktu) {
        item.setDurasi(waktu);
        dataKendaraan.add(item);
    }

    public void inputDenganJam(KendaraanUmum item, int jamMasuk, int jamKeluar) {
        item.setDurasi(jamKeluar - jamMasuk);
        dataKendaraan.add(item);
    }

    public ArrayList<KendaraanUmum> getDataKendaraan() {
        return dataKendaraan;
    }

    public double totalBiayaParkir() {
        double total = 0;
        for (KendaraanUmum k : dataKendaraan) {
            total += k.hitungTarif();
        }
        return total;
    }
}
