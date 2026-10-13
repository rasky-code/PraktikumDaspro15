
import java.util.Scanner;

public class KasirKopiSenja {
    public static void main(String[] args) {

        // Deklarasi Scanner
        Scanner input = new Scanner(System.in);

        // Deklarasi variabel
        final int hargaPerCup = 18000;
        int jumlahCup, uangBayar;
        int totalHarga, diskon, totalBayar;
        int kembalian, kurang;

        // Input jumlah pembelian dan uang pembayaran
        System.out.println("=== KASIR KEDAI KOPI SENJA ===");
        System.out.print("Masukkan jumlah cup: ");
        jumlahCup = input.nextInt();
        System.out.print("Masukkan uang bayar (Rp): ");
        uangBayar = input.nextInt();

        // Menghitung total harga
        totalHarga = jumlahCup * hargaPerCup;

        // Menentukan diskon
        diskon = 0;

        if (totalHarga >= 100000) {
            diskon = totalHarga * 10 / 100;
        }

        // Menghitung total pembayaran setelah diskon
        totalBayar = totalHarga - diskon;

        // Menampilkan rincian pembayaran
        System.out.println("\n=== RINCIAN PEMBAYARAN ===");
        System.out.println("Total harga : Rp " + String.format("%,d", totalHarga).replace(',', '.'));
        System.out.println("Diskon      : Rp " + String.format("%,d", diskon).replace(',', '.'));
        System.out.println("Total bayar : Rp " + String.format("%,d", totalBayar).replace(',', '.'));

        // Memeriksa kecukupan uang pembayaran
        if (uangBayar >= totalBayar) {
            kembalian = uangBayar - totalBayar;

            System.out.println("Kembalian   : Rp " + String.format("%,d", kembalian).replace(',', '.'));
        } else {
            kurang = totalBayar - uangBayar;

            System.out.println("Uang tidak cukup, kurang Rp " + String.format("%,d", kurang).replace(',', '.'));
        }

        input.close();
    }
}
