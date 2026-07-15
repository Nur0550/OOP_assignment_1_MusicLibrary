import java.sql.*;
import java.util.ArrayList;

// ======================================================
// Класс ArtistDAO
// Отвечает за работу с таблицей artists.
// Реализует CRUD (Create, Read, Update, Delete).
// ======================================================

public class ArtistDAO {

    // ======================================================
    // CREATE
    // Добавление нового исполнителя
    // ======================================================

    public int addArtist(Artist artist) {

        String sql = "INSERT INTO artists(name, country, age) VALUES (?, ?, ?)";

        try (
                Connection connection = DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(
                                sql,
                                Statement.RETURN_GENERATED_KEYS
                        )
        ) {

            statement.setString(1, artist.getName());
            statement.setString(2, artist.getCountry());
            statement.setInt(3, artist.getAge());

            statement.executeUpdate();

            ResultSet result = statement.getGeneratedKeys();

            if (result.next()) {

                int id = result.getInt(1);

                System.out.println("Artist added successfully! ID = " + id);

                return id;
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return -1;

    }

    // ======================================================
    // READ
    // Получить всех исполнителей
    // ======================================================

    public ArrayList<Artist> getAllArtists() {

        ArrayList<Artist> artists = new ArrayList<>();

        String sql = "SELECT * FROM artists";

        try (

                Connection connection = DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql);

                ResultSet result =
                        statement.executeQuery()

        ) {

            while (result.next()) {

                Artist artist = new Artist(

                        result.getString("name"),
                        result.getString("country"),
                        result.getInt("age")

                );

                artists.add(artist);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return artists;

    }

    // ======================================================
    // UPDATE
    // Изменить страну исполнителя
    // ======================================================

    public void updateArtist(int id, String newCountry) {

        String sql = "UPDATE artists SET country = ? WHERE id = ?";

        try (

                Connection connection = DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ) {

            statement.setString(1, newCountry);
            statement.setInt(2, id);

            statement.executeUpdate();

            System.out.println("Artist updated successfully!");

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    // ======================================================
    // DELETE
    // Удалить исполнителя
    // ======================================================

    public void deleteArtist(int id) {

        String sql = "DELETE FROM artists WHERE id = ?";

        try (

                Connection connection = DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ) {

            statement.setInt(1, id);

            statement.executeUpdate();

            System.out.println("Artist deleted successfully!");

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}