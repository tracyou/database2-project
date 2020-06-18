package nl.hva.ict.data.MySQL;

import nl.hva.ict.models.Lodge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLLodge extends MySQL<Lodge>{

    private List<Lodge> lodges;

    public MySQLLodge(){
        lodges =  new ArrayList<>();
        load();
    }

    private void load() {

        String sql = "SELECT accomodatie.accomodatieCode, accomodatie.naam, accomodatie.stad, accomodatie.land, accomodatie.kamer, " +
                "accomodatie.personen, safarilodge.prijsPerWeek, safarilodge.autoHuur " +
                "FROM safarilodge INNER JOIN accomodatie ON accomodatie.accomodatieCode = safarilodge.accomodatieCode";

        try {
            PreparedStatement ps = getStatement(sql);
            ResultSet rs = executeSelectPreparedStatement(ps);

            while (rs.next()){
                String accomodatieCode = rs.getString("accomodatieCode");
                String naam = rs.getString("naam");
                String stad = rs.getString("stad");
                String land = rs.getString("land");
                String kamer = rs.getString("kamer");
                double prijs = rs.getDouble("prijsPerWeek");
                int personen = rs.getInt("personen");
                String autoHuur = rs.getString("autoHuur");

                Lodge lodge = new Lodge(accomodatieCode, naam, stad, land, kamer, personen,null, prijs,autoHuur);
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
        String sql = "{call verwijderAccommodatie('"+ object +")}";

        if (object == null)
            return;

        try {
            PreparedStatement ps = getStatement(sql);
            ps.setString(1, object.getAccommodatieCode());
            ResultSet rs = executeSelectPreparedStatement(ps);
            reload();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reload(){
        lodges.clear();
        load();
    }
}
