package nl.hva.ict.models;

import nl.hva.ict.data.Identifable;

import java.io.Serializable;

public class Lodge implements Identifable, Serializable {

    private String accommodatieCode;
    private String naam;
    private String stad;
    private String land;
    private String kamer;
    private double prijsPerWeek;
    private int personen;
    private String autoHuur;

    public Lodge(String accommodatieCode, String naam, String stad, String land
            , String kamer, double prijsPerWeek, int personen, String autoHuur) {
        this.accommodatieCode = accommodatieCode;
        this.naam = naam;
        this.stad = stad;
        this.land = land;
        this.kamer = kamer;
        this.prijsPerWeek = prijsPerWeek;
        this.personen = personen;
        this.autoHuur = autoHuur;
    }

    public String getAccommodatieCode() {
        return accommodatieCode;
    }

    public void setAccommodatieCode(String accommodatieCode) {
        this.accommodatieCode = accommodatieCode;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getKamer() {
        return kamer;
    }

    public void setKamer(String kamer) {
        this.kamer = kamer;
    }

    public double getPrijsPerWeek() {
        return prijsPerWeek;
    }

    public void setPrijsPerWeek(double prijsPerWeek) {
        this.prijsPerWeek = prijsPerWeek;
    }

    public int getPersonen() {
        return personen;
    }

    public void setPersonen(int personen) {
        this.personen = personen;
    }

    public String isAutoHuur() {
        return autoHuur;
    }

    public void setAutoHuur(String autoHuur) {
        this.autoHuur = autoHuur;
    }

    @Override
    public String toString() {
        return "Logde: " + accommodatieCode + " " + naam + " " + stad;
    }
}
