import Users.MemberUser;
import Users.User;

public class Reservasi {
    private User user;
    private Lapangan lapangan;
    private Jadwal jadwal;

    public Reservasi(User user, Lapangan lapangan, Jadwal jadwal) {
        this.user = user;
        this.lapangan = lapangan;
        this.jadwal = jadwal;
    }

    // Method Overloading
    public void buatReservasi() {
        System.out.println("Reservasi berhasil untuk " + user.getNama() + " tanpa diskon tambahan.");
    }

    public void buatReservasi(boolean denganDiskon) {
        if (denganDiskon && user instanceof MemberUser ) {
            System.out.println("Reservasi berhasil untuk " + user.getNama() + " dengan diskon member.");
        } else {
            buatReservasi();
        }
    }

    public double hitungTotal() {
        double hargaDasar = lapangan.getHargaPerJam() * jadwal.getDurasi();
        return user.hitungHarga(hargaDasar);
    }

    public void cetakStruk() {
        double total = hitungTotal();
        Struk struk = new Struk(user, lapangan, jadwal, total);
        struk.cetakStruk();
    }
}