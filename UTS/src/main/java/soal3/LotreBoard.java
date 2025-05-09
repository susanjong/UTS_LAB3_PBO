package soal3;

import java.util.Random;

public class LotreBoard {
    private final int jumlahBaris = 4;
    private final int jumlahKolom = 5;
    private final int[][] papanData;
    private final boolean[][] kotakTerbuka;

    public LotreBoard() {
        papanData = new int[jumlahBaris][jumlahKolom];
        kotakTerbuka = new boolean[jumlahBaris][jumlahKolom];
        buatPapan();
    }

    // Membuat papan dengan bom secara acak
    public void buatPapan() {
        Random acak = new Random();
        int jumlahBom = 0;

        while (jumlahBom < 2) {
            int baris = acak.nextInt(jumlahBaris);
            int kolom = acak.nextInt(jumlahKolom);
            if (papanData[baris][kolom] == 0) {
                papanData[baris][kolom] = 1; // 1 berarti bom
                jumlahBom++;
            }
        }
    }

    // Menampilkan papan
    public void tampilkanPapan() {
        for (int i = 0; i < jumlahBaris; i++) {
            for (int j = 0; j < jumlahKolom; j++) {
                if (kotakTerbuka[i][j]) {
                    if (papanData[i][j] == 1) {
                        System.out.print("X ");
                    } else {
                        System.out.print("O ");
                    }
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    // Melakukan tebakan
    public boolean tebak(int baris, int kolom) {
        kotakTerbuka[baris][kolom] = true;
        return papanData[baris][kolom] != 1;
    }

    // Mengecek apakah kotak sudah dibuka sebelumnya
    public boolean sudahTerbuka(int baris, int kolom) {
        return kotakTerbuka[baris][kolom];
    }

    // Mengecek apakah permainan selesai (semua kotak aman terbuka)
    public boolean apakahMenang() {
        for (int i = 0; i < jumlahBaris; i++) {
            for (int j = 0; j < jumlahKolom; j++) {
                if (papanData[i][j] == 0 && !kotakTerbuka[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getJumlahBaris() {
        return jumlahBaris;
    }

    public int getJumlahKolom() {
        return jumlahKolom;
    }
}
