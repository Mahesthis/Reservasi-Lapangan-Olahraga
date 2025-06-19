import Users.User;

public class Struk {
    private User user;
    private Lapangan lapangan;
    private Jadwal jadwal;
    private double total;

    public Struk(User user, Lapangan lapangan, Jadwal jadwal, double total) {
        this.user = user;
        this.lapangan = lapangan;
        this.jadwal = jadwal;
        this.total = total;
    }

    public void cetakStruk() {
        String formatString = "| %-18s: %-25s |\n";

        // Mencetak struk
        System.out.println("\n+-----------------------------------------------+");
        System.out.println("|               STRUK PEMBAYARAN                |");
        System.out.println("+-----------------------------------------------+");
        System.out.printf(formatString, "Nama", user.getNama());
        System.out.printf(formatString, "Email", user.getEmail());
        System.out.println("|-----------------------------------------------|");
        System.out.printf(formatString, "Jenis Lapangan", lapangan.getJenis());
        System.out.printf(formatString, "Tanggal", jadwal.getTanggal());
        System.out.printf(formatString, "Jam Mulai", jadwal.getJamMulai());
        System.out.printf(formatString, "Durasi", jadwal.getDurasi() + " jam");
        System.out.println("|-----------------------------------------------|");
        System.out.printf("| %-18s: %-25s |\n", "Total Bayar", total);
        System.out.println("+-----------------------------------------------+");
    }
}