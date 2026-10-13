
import java.util.Scanner;

public class StudiKasus225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Validasi Dokumen Prestasi Mahasiswa ===");
        System.out.print("Nama mahasiswa : ");
        String nama = sc.nextLine().trim();
        System.out.print("Jenis kegiatan (BELMAWA/BAKORMA/MANDIRI/PKM/LAINNYA) : ");
        String jenis = sc.nextLine().trim().toUpperCase();
        System.out.print("Jumlah dokumen : ");
        int jumlahDokumen = sc.nextInt();

        // Memeriksa jumlah dokumen
        if (jumlahDokumen < 0 || jumlahDokumen > 4) {
            System.out.println("Jumlah dokumen harus antara 0 sampai 4.");
            sc.close();
            return;
        }

        boolean lomba = jenis.equals("BELMAWA")
                || jenis.equals("BAKORMA")
                || jenis.equals("MANDIRI");

        boolean pkm = jenis.equals("PKM");
        boolean lainnya = jenis.equals("LAINNYA");

        // Memeriksa jenis kegiatan
        if (!lomba && !pkm && !lainnya) {
            System.out.println("Jenis kegiatan tidak valid.");
            sc.close();
            return;
        }

        int peringkat = 0;
        int statusPKM = -1;

        // Meminta data tambahan sesuai kegiatan
        if (lomba) {
            System.out.print("Peringkat juara (0 jika bukan juara) : ");
            peringkat = sc.nextInt();
        } else if (pkm) {
            System.out.print("Status pendanaan PKM (1 = lolos, 0 = tidak) : ");
            statusPKM = sc.nextInt();
        }

        System.out.println("\nNama mahasiswa : " + nama);
        System.out.println("Jenis kegiatan : " + jenis);
        System.out.println("Jumlah dokumen : " + jumlahDokumen);

        // Menentukan status kelengkapan dan dana
        if (jumlahDokumen < 4) {
            int kurang = 4 - jumlahDokumen;

            System.out.println("Status : Dokumen tidak lengkap (kurang " + kurang + " dokumen). Dana penghargaan tidak diberikan.");

        } else {
            if (lomba) {
                if (peringkat >= 1 && peringkat <= 3) {
                    System.out.println("Status : Dokumen lengkap. Dana penghargaan diberikan.");
                } else if (peringkat == 0) {
                    System.out.println("Status : Bukan Juara 1, 2, atau 3. Dana penghargaan tidak diberikan.");
                } else {
                    System.out.println("Status : Peringkat tidak valid. Masukkan angka 0 sampai 3.");
                }

            } else if (pkm) {
                if (statusPKM == 1) {
                    System.out.println("Status : PKM lolos pendanaan. Dana penghargaan diberikan.");
                } else if (statusPKM == 0) {
                    System.out.println("Status : PKM tidak lolos pendanaan. Dana penghargaan tidak diberikan.");
                } else {
                    System.out.println("Status : Data pendanaan PKM tidak valid.");
                }

            } else {
                System.out.println("Status : Kegiatan Lainnya tidak memperoleh dana penghargaan.");
            }
        }

        sc.close();
    }
}
