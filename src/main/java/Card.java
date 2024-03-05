import java.time.LocalDate;

public class Card {
    private String namaPemilik;
    private String namaBank;
    private String noRek;
    private LocalDate masaAktif;

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getNoRek() {
        return noRek;
    }

    public void setNoRek(String noRek) {
        this.noRek = noRek;
    }

    public LocalDate getMasaAktif() {
        return masaAktif;
    }

    public void setMasaAktif(LocalDate masaAktif) {
        this.masaAktif = masaAktif;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }
}