package nl.hva.ict.data.MySQL;

import nl.hva.ict.models.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MySQLBoekingsOverzicht extends MySQL<BoekingsOverzicht> {

    private List<BoekingsOverzicht> boekingsOverzichten;

    public MySQLBoekingsOverzicht(){
        boekingsOverzichten = new ArrayList<>();
        load();
    }

    private void load() {

        String sql = "SELECT reservering.*, accomodatie.naam, accomodatie.stad, accomodatie.land, accomodatie.soort, reiziger.voornaam, reiziger.achternaam, reiziger.plaats " +
                "FROM reservering " +
                "INNER JOIN reiziger on reservering.reizigersCode = reiziger.reizigersCode " +
                "INNER JOIN accomodatie on reservering.accomodatieCode = accomodatie.accomodatieCode";

        try {
            PreparedStatement ps = getStatement(sql);
            ResultSet rs = executeSelectPreparedStatement(ps);

            while (rs.next()) {
                int idReservering = rs.getInt("idReservering");
                LocalDate aankomstDatum = LocalDate.parse(rs.getString("aankomstDatum"));
                LocalDate vertrekDatum = LocalDate.parse(rs.getString("vertrekDatum"));
                String betaald = rs.getString("betaald");
                String accommodatieCode = rs.getString("accomodatieCode");
                String reizerCode = rs.getString("reizigersCode");
                String voornaam = rs.getString("voornaam");
                String achternaam = rs.getString("achternaam");
                String plaats = rs.getString("plaats");
                String land = rs.getString("land");
                String accommodatieNaam = rs.getString("naam");
                String accommodatieStad = rs.getString("stad");
                String accommodatieLand = rs.getString("land");
                String accommodatieType = rs.getString("soort");

                Reservering reservering = new Reservering(idReservering, accommodatieCode, reizerCode, aankomstDatum, vertrekDatum, betaald);
                Reiziger reiziger = new Reiziger(reizerCode, voornaam, achternaam, null, null, plaats, land, null);
                Accommodatie accommodatie = new Accommodatie();
                accommodatie.setNaam(accommodatieNaam);
                accommodatie.setStad(accommodatieStad);
                accommodatie.setLand(accommodatieLand);
                boekingsOverzichten.add(new BoekingsOverzicht(accommodatie, reiziger, reservering));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public List<BoekingsOverzicht> getBoekingVoor(String Reizigerscode){

        List<BoekingsOverzicht> reserveringVoor = new ArrayList<>();

        String sql = "SELECT reservering.*, accomodatie.naam, accomodatie.stad, accomodatie.land, accomodatie.soort, reiziger.voornaam, reiziger.achternaam, reiziger.plaats " +
                "FROM reservering " +
                "INNER JOIN reiziger on reservering.reizigersCode = reiziger.reizigersCode " +
                "INNER JOIN accomodatie on reservering.accomodatieCode = accomodatie.accomodatieCode "+
                "WHERE reservering.reizigersCode = '"+ Reizigerscode +"'";

        try {
            PreparedStatement ps = getStatement(sql);
            ResultSet rs = executeSelectPreparedStatement(ps);

            while (rs.next()) {
                int idReservering = rs.getInt("idReservering");
                LocalDate aankomstDatum = LocalDate.parse(rs.getString("aankomstDatum"));
                LocalDate vertrekDatum = LocalDate.parse(rs.getString("vertrekDatum"));
                String betaald = rs.getString("betaald");
                String accommodatieCode = rs.getString("accomodatieCode");
                String reizigerCode = rs.getString("reizigersCode");

                String reizigerVoornaam = rs.getString("voornaam");
                String reizigerAchternaam = rs.getString("achternaam");
                String reizigerPlaats = rs.getString("plaats");
                String accommodatieNaam = rs.getString("naam");
                String accommodatieStad = rs.getString("stad");
                String accommodatieLand = rs.getString("land");
                String accommodatieType = rs.getString("soort");

                Reservering reservering = new Reservering(idReservering, accommodatieCode, reizigerCode,aankomstDatum, vertrekDatum, betaald);
                Accommodatie accommodatie = new Accommodatie();
                accommodatie.setNaam(accommodatieNaam);
                accommodatie.setStad(accommodatieStad);
                accommodatie.setLand(accommodatieLand);
                accommodatie.setType(accommodatieType);

                Reiziger reiziger = new Reiziger();
                reiziger.setVoornaam(reizigerVoornaam);
                reiziger.setAchternaam(reizigerAchternaam);
                reiziger.setPlaats(reizigerPlaats);

                reserveringVoor.add(new BoekingsOverzicht(accommodatie, reiziger, reservering));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reserveringVoor;
    }

    public List<Reiziger> GeboektOp(String pCode, LocalDate pDatum) {

        List<Reiziger> geboektOp = new ArrayList<>();
        Date date = java.sql.Date.valueOf(pDatum);

        String sql = "SELECT GeboektOp('" + pCode + "', '" + pDatum + "') AS reiziger_id";

        try {
            PreparedStatement ps = getStatement(sql);
            ps.setString(1, pCode);
            ps.setDate(2, date);
            ResultSet rs = executeSelectPreparedStatement(ps);

            while (rs.next()) {
                String reizigerCode = rs.getString("reizigersCode");
                String reizigerVoornaam = rs.getString("voornaam");
                String reizigerAchternaam = rs.getString("achternaam");
                String reizigerPlaats = rs.getString("plaats");

                Reiziger reiziger = new Reiziger();
                reiziger.setReizigersCode(reizigerCode);
                reiziger.setVoornaam(reizigerVoornaam);
                reiziger.setAchternaam(reizigerAchternaam);
                reiziger.setPlaats(reizigerPlaats);
                geboektOp.add(reiziger);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return geboektOp;
    }


    @Override
    public List<BoekingsOverzicht> getAll() {
        return boekingsOverzichten;
    }

    @Override
    public BoekingsOverzicht get(String id) {
        return null;
    }

    @Override
    public void add(BoekingsOverzicht object) {

    }

    @Override
    public void update(BoekingsOverzicht object) {

    }

    @Override
    public void remove(BoekingsOverzicht object) {

    }
}
