import java.sql.*;
import java.util.ArrayList;

// ======================================================
// Класс SongDAO
// Отвечает за работу с таблицей songs.
// Реализует CRUD (Create, Read, Update, Delete).
// ======================================================

public class SongDAO {

    // ======================================================
    // CREATE
    // Добавление песни
    // ======================================================

    public void addSong(Song song, int artistId) {

        String sql = "INSERT INTO songs(title, genre, duration, artist_id) VALUES (?, ?, ?, ?)";

        try (

                Connection connection = DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ) {

            statement.setString(1, song.getTitle());
            statement.setString(2, song.getGenre());
            statement.setInt(3, song.getDuration());
            statement.setInt(4, artistId);

            statement.executeUpdate();

            System.out.println("Song added successfully!");

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    // ======================================================
    // READ
    // Получить все песни
    // ======================================================

    public ArrayList<Song> getAllSongs() {

        ArrayList<Song> songs = new ArrayList<>();

        String sql = """
                SELECT
                    songs.title,
                    songs.genre,
                    songs.duration,
                    artists.name,
                    artists.country,
                    artists.age
                FROM songs
                JOIN artists
                ON songs.artist_id = artists.id
                """;

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

                Song song = new Song(

                        result.getString("title"),
                        result.getString("genre"),
                        result.getInt("duration"),
                        artist

                );

                songs.add(song);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return songs;

    }

    // ======================================================
    // UPDATE
    // Изменить жанр песни
    // ======================================================

    public void updateSongGenre(int id, String genre) {

        String sql = "UPDATE songs SET genre = ? WHERE id = ?";

        try (

                Connection connection = DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ) {

            statement.setString(1, genre);
            statement.setInt(2, id);

            statement.executeUpdate();

            System.out.println("Song updated successfully!");

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    // ======================================================
    // DELETE
    // Удалить песню
    // ======================================================

    public void deleteSong(int id) {

        String sql = "DELETE FROM songs WHERE id = ?";

        try (

                Connection connection = DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ) {

            statement.setInt(1, id);

            statement.executeUpdate();

            System.out.println("Song deleted successfully!");

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}