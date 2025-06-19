package Users;
public class GuestUser extends User {
    private final double diskon;

    public GuestUser(String nama, String email) {
        super(nama, email);
        this.diskon = 0.0; // Tidak ada diskon
    }

    @Override
    public double getDiskon() {
        return diskon;
    }

    @Override
    public double hitungHarga(double total) {
        return total;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Tamu: " + getNama() + " | Email: " + getEmail() + " | Tidak mendapatkan diskon");
    }
}