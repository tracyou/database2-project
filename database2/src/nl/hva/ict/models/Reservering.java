package nl.hva.ict.models;

import nl.hva.ict.data.Identifable;

import java.io.Serializable;
import java.time.LocalDate;

public class Reservering implements Identifable, Serializable {

    private int idReservering;
    private String accommodatieCode;
    private String reizigersCode;
    private LocalDate aankomstDatum;
    private LocalDate vertrekDatum;
    private String betaald;

    public Reservering(int idReservering, String accommodatieCode, String reizigersCode,
                       LocalDate aankomstDatum, LocalDate vertrekDatum, String betaald) {
        this.idReservering = idReservering;
        this.accommodatieCode = accommodatieCode;
        this.reizigersCode = reizigersCode;
        this.aankomstDatum = aankomstDatum;
        this.vertrekDatum = vertrekDatum;
        this.betaald = betaald;
    }

    public Reservering() {
    }

    public int getIdReservering() {
        return idReservering;
    }

    public void setIdReservering(int idReservering) {
        this.idReservering = idReservering;
    }

    public String getAccommodatieCode() {
        return accommodatieCode;
    }

    public void setAccommodatieCode(String accommodatieCode) {
        this.accommodatieCode = accommodatieCode;
    }

    public String getReizigersCode() {
        return reizigersCode;
    }

    public void setReizigersCode(String reizigersCode) {
        this.reizigersCode = reizigersCode;
    }

    public LocalDate getAankomstDatum() {
        return aankomstDatum;
    }

    public void setAankomstDatum(LocalDate aankomstDatum) {
        this.aankomstDatum = aankomstDatum;
    }

    public LocalDate getVertrekDatum() {
        return vertrekDatum;
    }

    public void setVertrekDatum(LocalDate vertrekDatum) {
        this.vertrekDatum = vertrekDatum;
    }

    public String getBetaald() {
        return betaald;
    }

    public void setBetaald(String betaald) {
        this.betaald = betaald;
    }

    @Override
    public String toString() {
        return "Reservering{" +
                "idReservering=" + idReservering +
                ", accommodatieCode='" + accommodatieCode + '\'' +
                ", reizigersCode='" + reizigersCode + '\'' +
                ", aankomstDatum=" + aankomstDatum +
                ", vertrekDatum=" + vertrekDatum +
                ", betaald=" + betaald +
                '}';
    }
}
