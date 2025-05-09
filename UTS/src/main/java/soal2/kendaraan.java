package soal2;

public class kendaraan {
    private String jenis;
    private int lamaParkir;
    private double biayaPerJam;

    public kendaraan(String jenis) {
        this.jenis = jenis.toLowerCase();
        switch(this.jenis) {
            case "motor" -> biayaPerJam = 2000;
            case "mobil" -> biayaPerJam = 5000;
            case "truk"  -> biayaPerJam = 10000;
            default -> throw new IllegalArgumentException("Jenis kendaraan tidak valid");

        }
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }


    public int getLamaParkir() {
        return lamaParkir;
    }


    public void setLamaParkir(int lamaParkir) {
        this.lamaParkir = lamaParkir;
    }

    public double getBiayaPerJam() {
        return biayaPerJam;
    }

    public void setBiayaPerJam(double biayaPerJam) {
        this.biayaPerJam = biayaPerJam;
    }

    public double hitungBiaya() {
        double total = lamaParkir * biayaPerJam;
        if (lamaParkir > 5) {
            total *= 0.9;
        }
        return total;
    }

}
