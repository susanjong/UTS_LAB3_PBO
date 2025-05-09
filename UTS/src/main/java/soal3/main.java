package soal3;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LotreBoard papanLotre = new LotreBoard();

        System.out.println("======= Welcome to E-Lottery Gosok =======");

        while (true) {
            papanLotre.tampilkanPapan();

            // Meminta input koordinat baris dan kolom
            System.out.print("\nMasukkan tebakan anda (baris dan kolom) : ");
            int baris = scanner.nextInt();
            int kolom = scanner.nextInt();

            // Validasi input agar tidak di luar jangkauan papan
            if (baris < 0 || baris >= papanLotre.getJumlahBaris() || kolom < 0 || kolom >= papanLotre.getJumlahKolom()) {
                System.out.println("Koordinat di luar jangkauan!");
                continue;
            }

            // Cek apakah kotak sudah pernah dipilih sebelumnya
            if (papanLotre.sudahTerbuka(baris, kolom)) {
                System.out.println("Kotak telah dibuka sebelumnya!");
                continue;
            }

            // Lakukan proses tebakan
            boolean aman = papanLotre.tebak(baris, kolom);

            // Jika kena bom
            if (!aman) {
                System.out.println("BOOM! Anda menemukan bom! Permainan berakhir.");
                papanLotre.tampilkanPapan();
                break;
            } else {
                System.out.println("Kotak Aman");
                if (papanLotre.apakahMenang()) {
                    System.out.println("Selamat anda menang!");
                    papanLotre.tampilkanPapan();
                    break;
                }
            }
        }
    }
}
