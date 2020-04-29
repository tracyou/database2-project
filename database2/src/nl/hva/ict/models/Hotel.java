package nl.hva.ict.models;

import nl.hva.ict.data.Identifable;

import java.io.Serializable;

public class Hotel implements Identifable, Serializable {
    private String accommodatieCode;
    private String naam;
    private String stad;
    private String land;
    private String kamer;
    private double prijsPerNacht;
    private int personen;
    private boolean ontbijt;

    public Hotel(String accommodatieCode, String naam, String stad, String land, String kamer,
                 double prijsPerNacht, int personen, boolean ontbijt) {
        this.accommodatieCode = accommodatieCode;
        this.naam = naam;
        this.stad = stad;
        this.land = land;
        this.kamer = kamer;
        this.prijsPerNacht = prijsPerNacht;
        this.personen = personen;
        this.ontbijt = ontbijt;
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

    public double getPrijsPerNacht() {
        return prijsPerNacht;
    }

    public void setPrijsPerNacht(double prijsPerNacht) {
        this.prijsPerNacht = prijsPerNacht;
    }

    public int getPersonen() {
        return personen;
    }

    public void setPersonen(int personen) {
        this.personen = personen;
    }

    public boolean isOntbijt() {
        return ontbijt;
    }

    public void setOntbijt(boolean ontbijt) {
        this.ontbijt = ontbijt;
    }

    @Override
    public String toString() {
        return "Hotel:" + accommodatieCode + " " + naam + " " + stad;
    }
}
