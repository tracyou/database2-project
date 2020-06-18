package nl.hva.ict.models;

import nl.hva.ict.data.Identifable;

import java.io.Serializable;

public class Lodge extends Accommodatie implements Identifable, Serializable {

    private double prijsPerWeek;
    private String autoHuur;

    public Lodge(String accommodatieCode, String naam, String stad, String land, String kamer, int personen, String soort, double prijsPerWeek, String autoHuur) {
        super(accommodatieCode, naam, stad, land, kamer, personen, soort);
        this.prijsPerWeek = prijsPerWeek;
        this.autoHuur = autoHuur;
    }

    public Lodge() {

    }

    public String getPrijsPerWeek() {
        return String.valueOf(prijsPerWeek);
    }

    public void setPrijsPerWeek(double prijsPerWeek) {
        this.prijsPerWeek = prijsPerWeek;
    }

    public String getAutoHuur() {
        return autoHuur;
    }

    public void setAutoHuur(String autoHuur) {
        this.autoHuur = autoHuur;
    }
}
