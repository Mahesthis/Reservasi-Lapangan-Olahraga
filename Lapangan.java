public class Lapangan {
    private String jenis;
    private double hargaPerJam;

    public Lapangan(String jenis, double hargaPerJam) {
        this.jenis = jenis;
        this.hargaPerJam = hargaPerJam;
    }

    public String getJenis() {
        return jenis;
    }

    public double getHargaPerJam() {
        return hargaPerJam;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setHargaPerJam(double hargaPerJam) {
        this.hargaPerJam = hargaPerJam;
    }
}