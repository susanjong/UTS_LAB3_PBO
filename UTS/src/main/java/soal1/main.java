/*Overview:
1. Saya membuat soal nomor 1, yaitu sistem manajamen data karyawan.
2. Terdapat 3 class utama, yaitu Main.java, Perusahaan.java (menyimpan
   semua method dan daftar karyawan), dan Karyawan.java (pembuatan
   karyawan yang baru).
3. Saya membuat mengubah posisi karyawan dan gaji karyawan menjadi
   satu method mengubah data karyawan, dimana di dalamnya bisa mengubah
   posisi, gaji, dan divisi karyawan.
4. Saya membuat 2 method tambahan, yaitu menampilkan daftarKaryawan
   dan pencarian Karyawan berdasarkan ID.
5. Saya berusaha untuk menerapkan 3 pilar PBO. meliputi:
    1) Enkapsulasi, dengan memastikan semua atribut private dan hanya
       bisa diakses melalui method.
    2) Inheritance, dengan membuat 2 subclass, yaitu class
       Manager (tambahan atribut bonus) dan Intern (tambahan atribut
       asal univ dan durasi magang).
    3) Polymorphism, yaitu overloading pada total gaji, dimana Manager
       gaji ditambah dengan bonus.
6. Saya sudah berusaha sebisa mungkin untuk mengvalidasi dan menangani
   setiap kemungkinan error/kesalahan inputan.Jika terdapat
   algoritma/validasi/error-handling yang tidak pas atau kurang cocok,
   maka mohon maklumnya.
 */

package soal1;

import java.util.Scanner;

//main class
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //pemanggilan objek perusahaan jadi bisa memanggil method"
        Perusahaan perusahaan = new Perusahaan();

        //looping main interface
        while (true) {
            System.out.println("===============================================");
            System.out.println("|        Selamat datang di Perusahaan V       |");
            System.out.println("| Sistem Manajemen Akun Karyawan Perusahaan V |");
            System.out.println("===============================================");
            System.out.println("| 1. Menambah Karyawan                        |");
            System.out.println("| 2. Menghapus Karyawan                       |");
            System.out.println("| 3. Mengubah Data Karyawan                   |");
            System.out.println("| 4. Daftar Karyawan                          |");
            System.out.println("| 5. Pencarian Karyawan                       |");
            System.out.println("| 6. Keluar                                   |");
            System.out.println("===============================================");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1: perusahaan.tambahKaryawan(); break;
                case 2: perusahaan.hapusKaryawan(); break;
                case 3: perusahaan.ubahKaryawan(); break;
                case 4: perusahaan.daftarKaryawan(); break;
                case 5: perusahaan.pencarianKaryawan(); break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan layanan kami!");
                    return;
                default:
                    System.out.println("Inputan tidak valid!");
            }
        }
    }
}
