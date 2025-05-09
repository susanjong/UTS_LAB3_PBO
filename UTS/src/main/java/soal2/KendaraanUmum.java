package soal2;

public class KendaraanUmum {
    private String tipe;
    private int durasi;

    public KendaraanUmum(String tipe) {
        if (!tipe.equalsIgnoreCase("Motor") &&
                !tipe.equalsIgnoreCase("Mobil") &&
                !tipe.equalsIgnoreCase("Truk")) {
            throw new IllegalArgumentException("Jenis kendaraan tidak valid.");
        }
        this.tipe = tipe;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    public int getDurasi() {
        return durasi;
    }

    public String getTipe() {
        return tipe;
    }

    public double hitungTarif() {
        double tarif;
        switch (tipe.toLowerCase()) {
            case "motor":
                tarif = 2000;
                break;
            case "mobil":
                tarif = 5000;
                break;
            case "truk":
                tarif = 8000;
                break;
            default:
                tarif = 0;
        }
        return tarif * durasi;
    }
}
