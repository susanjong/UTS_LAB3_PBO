package soal2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProgramParkir sistem = new ProgramParkir();

        System.out.println("======= Selamat Datang di ParkirBaru =======");

        while (true) {
            System.out.print("\nMasukkan jenis kendaraan (Motor/Mobil/Truk): ");
            String tipe = scan.nextLine();

            System.out.print("Pilih metode durasi (Manual/Jam): ");
            String cara = scan.nextLine();

            KendaraanUmum objKendaraan;
            try {
                objKendaraan = new KendaraanUmum(tipe);
            } catch (IllegalArgumentException e) {
                System.out.println("Jenis kendaraan tidak dikenali.");
                continue;
            }

            try {
                if (cara.equalsIgnoreCase("Manual")) {
                    System.out.print("Masukkan durasi (jam): ");
                    int lama = Integer.parseInt(scan.nextLine());
                    if (lama <= 0) {
                        System.out.println("Durasi tidak valid.");
                        continue;
                    }
                    sistem.inputManual(objKendaraan, lama);
                } else if (cara.equalsIgnoreCase("Jam")) {
                    System.out.print("Jam Masuk: ");
                    int jamIn = Integer.parseInt(scan.nextLine());
                    System.out.print("Jam Keluar: ");
                    int jamOut = Integer.parseInt(scan.nextLine());
                    if (jamOut <= jamIn) {
                        System.out.println("Jam keluar harus lebih besar dari jam masuk.");
                        continue;
                    }
                    sistem.inputDenganJam(objKendaraan, jamIn, jamOut);
                } else {
                    System.out.println("Metode input tidak sesuai.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Format waktu salah.");
                continue;
            }

            System.out.println("\n---- RINCIAN PARKIR ----");
            System.out.println("Jenis Kendaraan : " + objKendaraan.getTipe());
            System.out.println("Durasi Parkir   : " + objKendaraan.getDurasi() + " jam");
            System.out.println("Biaya Total     : Rp" + objKendaraan.hitungTarif());

            System.out.print("\nIngin tambah kendaraan lagi? (y/n): ");
            if (!scan.nextLine().equalsIgnoreCase("y")) break;
        }

        System.out.println("\n======= RINGKASAN AKHIR =======");
        System.out.println("Total Kendaraan            : " + sistem.getDataKendaraan().size());
        System.out.println("Total Biaya Parkir         : Rp" + sistem.totalBiayaParkir());
        System.out.println("Terima Kasih.....");
    }
}
