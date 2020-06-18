package nl.hva.ict.models;


import nl.hva.ict.data.Identifable;

public class Accommodatie implements Identifable {

    private String accommodatieCode;
    private String naam;
    private String stad;
    private String land;
    private String kamer;
    private int personen;
    private String soort;


    public Accommodatie(String accommodatieCode, String naam, String stad, String land, String kamer, int personen, String soort) {
        this.accommodatieCode = accommodatieCode;
        this.naam = naam;
        this.stad = stad;
        this.land = land;
        this.kamer = kamer;
        this.personen = personen;
        this.soort = soort;
    }

    public Accommodatie() {
    }

    public String getType() {
        return soort;
    }

    public void setType(String type) {
        this.soort = type;
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

    public int getPersonen() {
        return personen;
    }

    public void setPersonen(int personen) {
        this.personen = personen;
    }

    @Override
    public String toString() {
        return naam + " - " + stad + " - " + land;
    }
}
