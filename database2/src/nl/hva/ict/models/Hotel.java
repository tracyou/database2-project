package nl.hva.ict.models;

import nl.hva.ict.data.Identifable;

import java.io.Serializable;

public class Hotel extends Accommodatie implements Identifable, Serializable {

    private double prijsPerNacht;
    private String ontbijt;

    public Hotel(String accommodatieCode, String naam, String stad, String land, String kamer, int personen, String soort, double prijsPerNacht, String ontbijt) {
        super(accommodatieCode, naam, stad, land, kamer, personen, soort);
        this.prijsPerNacht = prijsPerNacht;
        this.ontbijt = ontbijt;
    }

    public Hotel() {

    }

    public String getPrijsPerNacht() {
        return String.valueOf(prijsPerNacht);
    }

    public void setPrijsPerNacht(double prijsPerNacht) {
        this.prijsPerNacht = prijsPerNacht;
    }


    public String getOntbijt() {
        return ontbijt;
    }

    public void setOntbijt(String ontbijt) {
        this.ontbijt = ontbijt;
    }

}
