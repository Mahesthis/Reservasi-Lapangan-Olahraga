package Pembayaran;
public class PembayaranTransfer implements Pembayaran {
    @Override
    public void prosesPembayaran(double jumlah) {
        System.out.println("Transfer bank sebesar: Rp" + jumlah);
    }
}