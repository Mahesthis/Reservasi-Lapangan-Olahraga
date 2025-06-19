import java.util.Scanner;
import Pembayaran.Pembayaran;
import Pembayaran.PembayaranTransfer;
import Pembayaran.PembayaranTunai;
import Users.GuestUser;
import Users.MemberUser;
import Users.User;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean lanjut = true;

        while (lanjut) {
            System.out.println("\n=== SISTEM RESERVASI LAPANGAN ===");

            // Input data user
            System.out.print("Masukkan nama: ");
            String nama = input.nextLine();
            System.out.print("Masukkan email: ");
            String email = input.nextLine();

            User user = null;
            while (true) {
                System.out.print("Apakah Anda member? (y/n): ");
                String tipeUser  = input.nextLine();
                if (tipeUser .equalsIgnoreCase("y")) {
                    user = new MemberUser (nama, email);
                    break;
                } else if (tipeUser .equalsIgnoreCase("n")) {
                    System.out.print("apakah anda ingin menjadi member? (y/n): ");
                    String JadiMember = input.nextLine();
                    if (JadiMember.equalsIgnoreCase("y")) {
                        user = new MemberUser (nama,email); }
                    else if (JadiMember.equalsIgnoreCase("n")) {
                        user = new GuestUser (nama, email);
                    }
                    else { 
                        System.out.println("Masukkan hanya 'y' atau 'n'.");
                    }
                    break;
                } else {
                    System.out.println("Masukkan hanya 'y' atau 'n'.");
                }
            }

            // Pilih jenis lapangan
            Lapangan lapangan = null;
            while (lapangan == null) {
                JenisLapangan.tampilkanPilihan();
                System.out.print("Masukkan nomor pilihan (1-3): ");
                try {
                    int pilihan = Integer.parseInt(input.nextLine());
                    lapangan = JenisLapangan.buatLapangan(pilihan);
                    if (lapangan == null) {
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Masukkan angka yang valid.");
                }
            }

            // Input data jadwal
            System.out.print("Masukkan tanggal (YYYY-MM-DD): ");
            String tanggal = input.nextLine();
            System.out.print("Masukkan jam mulai (HH:MM): ");
            String jamMulai = input.nextLine();

            int durasi;
            while (true) {
                System.out.print("Masukkan durasi (jam): ");
                try {
                    durasi = Integer.parseInt(input.nextLine());
                    if (durasi > 0) break;
                    System.out.println("Durasi harus lebih dari 0!");
                } catch (NumberFormatException e) {
                    System.out.println("Masukkan angka yang valid!");
                }
            }

            Jadwal jadwal = new Jadwal(tanggal, jamMulai, durasi);

            // Buat reservasi
            Reservasi reservasi = new Reservasi(user, lapangan, jadwal);
            boolean isMember = user instanceof MemberUser ;
            reservasi.buatReservasi(isMember);
            double total = reservasi.hitungTotal();
            System.out.println("Total bayar: Rp" + total);

            // Pilih metode pembayaran
            Pembayaran pembayaran;
            while (true) {
                System.out.print("Pilih metode pembayaran ((c)tunai/(t)transfer): ");
                String metode = input.nextLine().toLowerCase();
                if (metode.equals("c")) {
                    pembayaran = new PembayaranTunai();
                    break;
                } else if (metode.equals("t")) {
                    pembayaran = new PembayaranTransfer();
                    break;
                } else {
                    System.out.println("Metode tidak valid. Pilih 'tunai' atau 'transfer'.");
                }
            }

            pembayaran.prosesPembayaran(total);
            // Cetak struk setelah pembayaran
            reservasi.cetakStruk();

            // Tanya apakah ingin lanjut
            while (true) {
                System.out.print("Apakah ingin memesan lagi? (y/n): ");
                String jawaban = input.nextLine().toLowerCase();
                if (jawaban.equals("n")) {
                    lanjut = false;
                    System.out.println("Terima kasih telah menggunakan sistem reservasi!");
                    break;
                } else if (jawaban.equals("y")) {
                    break; // lanjut loop
                } else {
                    System.out.println("Masukkan hanya 'y' atau 'n'.");
                }
            }
        }

        input.close();
    }
}