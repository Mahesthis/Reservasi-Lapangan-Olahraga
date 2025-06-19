package Users;
public class MemberUser extends User {
    private final double diskon;

    public MemberUser(String nama, String email) {
        super(nama, email);
        this.diskon = 0.2; // Diskon tetap 20%
    }

    @Override
    public double getDiskon() {
        return diskon;
    }

    @Override
    public double hitungHarga(double total) {
        return total * (1 - diskon);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Member: " + getNama() + " | Email: " + getEmail() + " | Diskon: " + (diskon * 100) + "%");
    }
}