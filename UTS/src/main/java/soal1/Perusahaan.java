package soal1;

//pemakaian library array list agar lebih dinamis
import java.util.ArrayList;
import java.util.Scanner;

//semua library dibawah utk pengelolaan format date
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.Period;

public class Perusahaan {
    //arraylist daftar karyawan
    private ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();

    //method utk mengecek apakah sudah ada ID di daftar biar gak duplikat
    private Karyawan validasiID(String tempID) {
        for (Karyawan karyawan : daftarKaryawan) {
            if (karyawan.getID().equals(tempID)) {
                return karyawan;
            }
        }
        return null;
    }

    //method utk mengecek apakah daftar kosong/sudah ada isi
    private boolean cekKosong() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada akun Karyawan terdaftar. Mohon untuk daftar akun terlebih dahulu!");
            System.out.println("Tekan enter untuk kembali.....");
            new Scanner(System.in).nextLine();
            return true;
        }
        return false;
    }

    //method utk menambah karyawan ke daftarkaryawan
    public void tambahKaryawan() {
        Scanner scanner = new Scanner(System.in);

        //untuk mengecek class apa yang mau dipake
        System.out.println("==========================================================================================");
        System.out.println("| 1. Karyawan Biasa                                                                      |");
        System.out.println("| 2. Manager                                                                             |");
        System.out.println("| 3. Intern                                                                              |");
        System.out.println("==========================================================================================");
        System.out.println("Masukkan tipe karyawan:");

        int tipe = 0;
        //validasi inputan
        boolean valid = false;
        while (!valid) {
            tipe = scanner.nextInt();
            scanner.nextLine(); //untuk memastikan inputan tidak lanjut ke inputan selanjutnya
            if (tipe == 1 || tipe == 2 || tipe == 3) {
                valid = true;
            } else {
                System.out.println("Inputan invalid!! Masukkan angka 1-3.");
            }
        }

        //pendeklarasian setiap atribut agar tidak terjadi error saat validasi looping
        String ID = "";
        String nama = "";
        String posisi = "";
        double gaji = 0.0;
        String divisi = "";
        LocalDate tanggalBergabung = null;

        valid = false;
        //validasi inputan ID dimana ID harus 3-digit dan harus angka
        while (!valid) {
            System.out.println("Masukkan ID Karyawan (3 digit): ");
            ID = scanner.nextLine();

            if (ID.length() != 3) {
                System.out.println("Inputan invalid!! ID harus 3 digit!");
                //validasi ID untuk memastikan bahwa semua angka dan tidak terdapat huruf
            } else if (!ID.matches("\\d{3}")) {
                System.out.println("Inputan invalid!! ID harus berisi angka semua!");
            } else if (validasiID(ID) != null) {
                System.out.println("ID Duplikat. Masukkan ID lain.");
            } else {
                valid = true;
            }
        }

        //validasi inputan nama Karyawan dimana nama tidak boleh kosong atau melebihi 100 chara
        valid = false;
        while (!valid) {
            System.out.println("Masukkan nama Karyawan: ");
            nama = scanner.nextLine();
            if (nama.isEmpty() || nama.length() > 100) {
                System.out.println("Inputan Invalid!! Nama tidak boleh kosong atau terlalu panjang.");
            } else {
                valid = true;
            }
        }

        //validasi inputan posisi Karyawan dimana posisi tidak boleh kosong atau melebihi 100 chara
        valid = false;
        while (!valid) {
            System.out.println("Masukkan posisi Karyawan: ");
            posisi = scanner.nextLine();
            if (posisi.isEmpty() || posisi.length() > 100) {
                System.out.println("Inputan Invalid!! Posisi tidak boleh kosong atau terlalu panjang.");
            } else {
                valid = true;
            }
        }

        //validasi inputan gaji karyawan dimana gaji tidak boleh negatif
        valid = false;
        while (!valid) {
            System.out.println("Masukkan gaji karyawan: ");
            gaji = scanner.nextDouble();
            scanner.nextLine();

            if (gaji < 0) {
                System.out.println("Inputan Invalid!! Gaji tidak boleh negatif.");
            } else {
                valid = true;
            }
        }

        //validasi inputan format tanggal, disini saya memakai template dari
        //library java.time.format.DateTimeParseException
        System.out.println("Masukkan tanggal bergabung karyawan (YYYY-MM-DD): ");
        while (tanggalBergabung == null) {
            String inputTanggal = scanner.nextLine();
            try {
                tanggalBergabung = LocalDate.parse(inputTanggal);
            } catch (DateTimeParseException e) {
                System.out.println("Format tanggal salah! Masukkan format YYYY-MM-DD.");
            }
        }

        //validasi inputan divisi Karyawan dimana divisi tidak boleh kosong dan tidak melebihi 100 chara
        valid = false;
        while (!valid) {
            System.out.println("Masukkan Divisi Karyawan: ");
            divisi = scanner.nextLine();
            if (divisi.isEmpty() || divisi.length() > 100) {
                System.out.println("Inputan Invalid!! Divisi tidak boleh kosong atau terlalu panjang.");
            } else {
                valid = true;
            }
        }

        //pengecekan class yang dipake untuk menambahkan inputan dan mencocokan parameter
        if (tipe == 1) {
            Karyawan karyawanTemp = new Karyawan(ID, nama, posisi, gaji, tanggalBergabung, divisi);
            daftarKaryawan.add(karyawanTemp);
        } else if (tipe == 2) {
            double bonus = 0.0;
            valid = false;
            //validasi inputan bonus Manager dimana bonus tidak boleh negatif
            while (!valid) {
                System.out.println("Masukkan bonus Manager: ");
                bonus = scanner.nextInt();
                scanner.nextLine();
                if (bonus >= 0.0) {
                    valid = true;
                } else {
                    System.out.println("Inputan Invalid!! Bonus harus angka positif.");
                }
            }
            Manager managerTemp = new Manager(ID, nama, posisi, gaji, tanggalBergabung, divisi, bonus);
            daftarKaryawan.add(managerTemp);
        } else if (tipe == 3) {
            System.out.println("Masukkan Universitas Intern: ");
            String universitas = scanner.nextLine();
            int durasi = 0;
            valid = false;
            //validasi inputan durasi magang Intern dimana durasi magang tidak boleh negatif
            while (!valid) {
                System.out.println("Masukkan durasi magang (bulan): ");
                durasi = scanner.nextInt();
                scanner.nextLine();
                if (durasi >= 0) {
                    valid = true;
                } else {
                    System.out.println("Inputan Invalid!! Durasi harus angka positif.");
                }
            }
            Intern internTemp = new Intern(ID, nama, posisi, gaji, tanggalBergabung, divisi, universitas, durasi);
            daftarKaryawan.add(internTemp);
        }

        System.out.println("Success!!. Data karyawan berhasil ditambahkan.");
        System.out.println("Tekan enter untuk kembali.....");
        scanner.nextLine();
    }

    //method untuk menghapus karyawan dari daftarKaryawan
    public void hapusKaryawan() {
        //mengecek apakah daftarKaryawan sudah berisi/kosong
        if (cekKosong()) return;

        Scanner scanner = new Scanner(System.in);
        String tempID = "";

        boolean valid = false;
        //validasi inputan ID karyawan
        while (!valid) {
            System.out.println("Masukkan ID Karyawan yang ingin dihapus: ");
            tempID = scanner.nextLine();

            if (tempID.length() != 3) {
                System.out.println("Inputan invalid!! ID harus 3 digit!");
            } else if (!tempID.matches("\\d{3}")) {
                System.out.println("Inputan invalid!! ID harus berisi angka semua!");
            } else {
                valid = true;
            }
        }

        //konfirmasi penghapusan karyawan
        Karyawan karyawan = validasiID(tempID);
        if (karyawan != null) {
            System.out.println("Apakah Anda yakin ingin menghapus Karyawan " + karyawan.getNama() + " ? (Iya/Tidak)");
            String jawaban = scanner.nextLine();
            if (jawaban.equalsIgnoreCase("Iya")) {
                daftarKaryawan.remove(karyawan);
                System.out.println("Karyawan berhasil dihapus.");
            } else {
                System.out.println("Penghapusan dibatalkan.");
            }
        } else {
            System.out.println("Karyawan tidak ditemukan.");
        }
        System.out.println("Tekan enter untuk kembali.....");
        scanner.nextLine();
    }

    //method untuk mengubah data karyawan
    public void ubahKaryawan() {
        //mengecek apakah daftarKaryawan sudah berisi/kosong
        if (cekKosong()) return;

        Scanner scanner = new Scanner(System.in);
        String tempID = "";

        boolean valid = false;
        //validasi inputan ID karyawan
        while (!valid) {
            System.out.println("Masukkan ID Karyawan yang ingin diubah datanya: ");
            tempID = scanner.nextLine();

            if (tempID.length() != 3) {
                System.out.println("Inputan invalid!! ID harus 3 digit!");
            } else if (!tempID.matches("\\d{3}")) {
                System.out.println("Inputan invalid!! ID harus berisi angka semua!");
            } else {
                valid = true;
            }
        }

        Karyawan karyawan = validasiID(tempID);
        if (karyawan != null) {
            //interface untuk memilih data apa yang mau diubah
            System.out.println("===============================================");
            System.out.println("| Sistem Manajemen Akun Karyawan Perusahaan V |");
            System.out.println("===============================================");
            System.out.println("| 1. Posisi Karyawan                          |");
            System.out.println("| 2. Gaji Pokok Karyawan                      |");
            System.out.println("| 3. Divisi Karyawan                          |");
            System.out.println("| 4. Keluar                                   |");
            System.out.println("===============================================");
            System.out.println("Masukkan data apa yang ingin diubah: ");
            int jawaban = scanner.nextInt();

            switch (jawaban) {
                case 1:
                    //mengubah posisi karyawan
                    System.out.println("Masukkan posisi baru:");
                    String posisiTemp = scanner.nextLine();
                    karyawan.setPosisi(posisiTemp);
                    System.out.println("Posisi berhasil diubah.");
                    break;
                case 2:
                    //mengubah gaji karyawan
                    System.out.println("Masukkan gaji baru:");
                    double gajiTemp = scanner.nextDouble();
                    karyawan.setGaji(gajiTemp);
                    System.out.println("Gaji berhasil diubah.");
                    break;
                case 3:
                    //mengubah divisi karyawan
                    System.out.println("Masukkan divisi baru:");
                    String divisiTemp = scanner.nextLine();
                    karyawan.setDivisi(divisiTemp);
                    System.out.println("Divisi berhasil diubah.");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Inputan tidak valid.");
            }
        } else {
            System.out.println("Karyawan tidak ditemukan.");
        }
        System.out.println("Tekan enter untuk kembali.....");
        scanner.nextLine();
    }

    //method untuk menampilkan daftarkaryawan
    public void daftarKaryawan() {
        //mengecek apakah daftarKaryawan sudah berisi/kosong
        if (cekKosong()) return;

        //pembuatan tabel daftarKaryawan
        System.out.println("==========================================================================================");
        System.out.println("|                                Daftar Karyawan Perusahaan V                            |");
        System.out.println("==========================================================================================");
        //mengatur header tabel untuk memastikan berapa jarak spasi per item header
        System.out.printf("%-5s %-5s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",
                "No", "ID", "Nama", "Posisi", "Total Gaji", "Tanggal Gabung", "Lama Gabung", "Divisi", "Keterangan");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

        //penomoran tabel
        int nomor = 1;

        //menghitung durasi bekerja secara otomaris mengunakan library java.time.Period
        for (Karyawan karyawan : daftarKaryawan) {
            Period lama = Period.between(karyawan.getTanggalBergabung(), LocalDate.now());
            String lamaGabung = lama.getYears() + " th " + lama.getMonths() + " bln";

            //pengecekan class mana yang dipake untuk mengatur atribut total gaji
            double totalGaji;
            if (karyawan instanceof Manager) {
                Manager manager = (Manager) karyawan;
                //method overloading
                totalGaji = manager.totalGaji(true);
            } else {
                totalGaji = karyawan.getGaji();
            }

            //pengecekan class mana yang dipake untuk mengatur atribut keterangan
            String keterangan = "-";
            if (karyawan instanceof Manager) {
                Manager manager = (Manager) karyawan;
                keterangan = "Bonus: Rp" + manager.getBonus();
            } else if (karyawan instanceof Intern) {
                Intern intern = (Intern) karyawan;
                keterangan = "Univ: " + intern.getUniversitas() + ", " + intern.getDurasiMagangBulan() + " bln";
            }

            //print out isi tabel dan mengatur jarak spasi
            System.out.printf("%-5d %-5s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",
                    nomor,
                    karyawan.getID(),
                    karyawan.getNama(),
                    karyawan.getPosisi(),
                    totalGaji,
                    karyawan.getTanggalBergabung(),
                    lamaGabung,
                    karyawan.getDivisi(),
                    keterangan
            );
            nomor++;
        }
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Total karyawan terdaftar: " + daftarKaryawan.size());
        System.out.println("Tekan enter untuk kembali.....");
        new Scanner(System.in).nextLine();
    }

    //method untuk mencari karyawan berdasarkan ID
    public void pencarianKaryawan() {
        //pengecekan apakah daftarKaryawan kosong/berisi
        if (cekKosong()) return;

        Scanner scanner = new Scanner(System.in);
        String tempID = "";

        //validasi inputan ID
        boolean valid = false;
        while (!valid) {
            System.out.println("Masukkan ID Karyawan yang ingin dicari: ");
            tempID = scanner.nextLine();

            if (tempID.length() != 3) {
                System.out.println("Inputan invalid!! ID harus 3 digit!");
            } else if (!tempID.matches("\\d{3}")) {
                System.out.println("Inputan invalid!! ID harus berisi angka semua!");
            } else {
                valid = true;
            }
        }

        //pengecekan apakah ID ditemukan atau enggak
        Karyawan karyawan = validasiID(tempID);
        if (karyawan != null) {
            System.out.println("==========================================================================================");
            System.out.println("|                               Data Karyawan Ditemukan                                  |");
            System.out.println("==========================================================================================");
            System.out.println("| ID: " + karyawan.getID());
            System.out.println("| Nama: " + karyawan.getNama());
            System.out.println("| Posisi: " + karyawan.getPosisi());
            System.out.println("| Gaji: Rp" + karyawan.getGaji());
            System.out.println("| Tanggal Bergabung: " + karyawan.getTanggalBergabung());
            System.out.println("| Divisi: " + karyawan.getDivisi());

            //pengecekan class mana yang dipake untuk mengatur print out atribut tambahan
            if (karyawan instanceof Manager) {
                Manager manager = (Manager) karyawan;
                System.out.println("| Bonus Manager: Rp" + manager.getBonus());
            } else if (karyawan instanceof Intern) {
                Intern intern = (Intern) karyawan;
                System.out.println("| Asal Universitas: " + intern.getUniversitas());
                System.out.println("| Durasi Magang: " + intern.getDurasiMagangBulan() + " bulan");
            }

            System.out.println("==========================================================================================");
        } else {
            System.out.println("Error!! Karyawan tidak ditemukan.");
        }
        System.out.println("Tekan enter untuk kembali.....");
        scanner.nextLine();
    }
}
