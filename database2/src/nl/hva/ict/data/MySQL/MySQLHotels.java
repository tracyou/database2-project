package nl.hva.ict.data.MySQL;

import nl.hva.ict.models.Hotel;
import nl.hva.ict.models.Lodge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLHotels extends MySQL<Hotel>{

    private List<Hotel> hotels;

    public MySQLHotels(){
        hotels = new ArrayList<>();
        load();
    }

    private void load() {
        String sql = "SELECT accomodatie.`accommodatie code`, accomodatie.naam, accomodatie.stad, accomodatie.land, accomodatie.kamer" +
                ", accomodatie.personen, hotel.`prijs per nacht`, hotel.`ontbijt`" +
                "FROM hotel" +
                "INNER JOIN accomodatie ON hotel.`accommodatie code` = accomodatie.`accommodatie code`";

        try {
            PreparedStatement ps = getStatement(sql);
            ResultSet rs = executeSelectPreparedStatement(ps);

            while (rs.next()){
                String accomodatieCode = rs.getString("accomodatie code");
                String naam = rs.getString("naam");
                String stad = rs.getString("stad");
                String land = rs.getString("land");
                String kamer = rs.getString("kamer");
                double prijs = rs.getDouble("prijs per nacht");
                int personen = rs.getInt("personen");
                String ontbijt = rs.getString("ontbijt");

                Hotel hotel = new Hotel(accomodatieCode, naam, stad, land, kamer, prijs, personen, ontbijt);
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Hotel> getAll() {
        return hotels;
    }

    @Override
    public Hotel get(String id) {
        return null;
    }

    @Override
    public void add(Hotel object) {

    }

    @Override
    public void update(Hotel object) {

    }

    @Override
    public void remove(Hotel object) {

    }

    public void reload(){
        hotels.clear();
        load();
    }
}
