package nl.hva.ict.data.MySQL;

import nl.hva.ict.models.Lodge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLLodges extends MySQL<Lodge>{

    private List<Lodge> lodges;

    public MySQLLodges(){
        lodges =  new ArrayList<>();
        load();
    }

    private void load() {

        String sql = "SELECT accomodatie.`accommodatie code`, accomodatie.naam, accomodatie.stad, accomodatie.land, accomodatie.kamer" +
                ", accomodatie.personen, `safari lodge`.`prijs per week`, `safari lodge`.`auto huur`" +
                "FROM `safari lodge`" +
                "INNER JOIN accomodatie ON `safari lodge`.`accommodatie code` = accomodatie.`accommodatie code`;";

        try {
            PreparedStatement ps = getStatement(sql);
            ResultSet rs = executeSelectPreparedStatement(ps);

            while (rs.next()){
                String accomodatieCode = rs.getString("`accomodatie code`");
                String naam = rs.getString("naam");
                String stad = rs.getString("stad");
                String land = rs.getString("land");
                String kamer = rs.getString("kamer");
                double prijs = rs.getDouble("`prijs per week`");
                int personen = rs.getInt("personen");
                String autoHuur = rs.getString("`auto huur`");

                Lodge lodge = new Lodge(accomodatieCode, naam, stad, land, kamer, prijs, personen,autoHuur);
                lodges.add(lodge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Lodge> getAll() {
        return lodges;
    }

    @Override
    public Lodge get(String id) {
        return null;
    }

    @Override
    public void add(Lodge object) {

    }

    @Override
    public void update(Lodge object) {

    }

    @Override
    public void remove(Lodge object) {

    }

    public void reload(){
        lodges.clear();
        load();
    }
}
