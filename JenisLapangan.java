public class JenisLapangan {
    public static Lapangan buatLapangan(int pilihan) {
        switch (pilihan) {
            case 1:
                return new Lapangan("Futsal", 100_000);
            case 2:
                return new Lapangan("Basket", 120_000);
            case 3:
                return new Lapangan("Badminton", 80_000);
            default:
                return null;
        }
    }

    public static void tampilkanPilihan() {
        System.out.println("Pilih jenis lapangan:");
        System.out.println("1. Futsal (Rp100.000/jam)");
        System.out.println("2. Basket (Rp120.000/jam)");
        System.out.println("3. Badminton (Rp80.000/jam)");
    }
}