package Pembayaran;
public class PembayaranTunai implements Pembayaran {
    @Override
    public void prosesPembayaran(double jumlah) {
        System.out.println("Pembayaran tunai sebesar: Rp" + jumlah);
    }
}