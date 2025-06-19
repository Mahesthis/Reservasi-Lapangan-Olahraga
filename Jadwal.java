public class Jadwal {
    private String tanggal;
    private String jamMulai;
    private int durasi; // dalam jam

    public Jadwal(String tanggal, String jamMulai, int durasi) {
        this.tanggal = tanggal;
        this.jamMulai = jamMulai;
        this.durasi = durasi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJamMulai() {
        return jamMulai;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }
}