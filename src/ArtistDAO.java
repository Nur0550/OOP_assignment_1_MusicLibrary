import java.sql.*;
import java.util.ArrayList;

public class ArtistDAO {

    // CREATE
    public void addArtist(Artist artist) {

        String sql = "INSERT INTO artists(name, country, age) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, artist.getName());
            statement.setString(2, artist.getCountry());
            statement.setInt(3, artist.getAge());

            statement.executeUpdate();

            System.out.println("Artist added.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public ArrayList<Artist> getAllArtists() {

        ArrayList<Artist> artists = new ArrayList<>();

        String sql = "SELECT * FROM artists";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                artists.add(
                        new Artist(
                                rs.getString("name"),
                                rs.getString("country"),
                                rs.getInt("age")
                        )
                );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artists;
    }

    // UPDATE
    public void updateArtist(int id, String newCountry) {

        String sql = "UPDATE artists SET country=? WHERE id=?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newCountry);
            statement.setInt(2, id);

            statement.executeUpdate();

            System.out.println("Artist updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // DELETE
    public void deleteArtist(int id) {

        String sql = "DELETE FROM artists WHERE id=?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.executeUpdate();

            System.out.println("Artist deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}