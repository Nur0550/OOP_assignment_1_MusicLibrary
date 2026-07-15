import java.sql.*;
import java.util.ArrayList;

// Класс отвечает за работу с таблицей songs
public class SongDAO {

    // CREATE
    public void addSong(Song song, int artistId) {

        String sql = "INSERT INTO songs(title, genre, duration, artist_id) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, song.getTitle());
            statement.setString(2, song.getGenre());
            statement.setInt(3, song.getDuration());
            statement.setInt(4, artistId);

            statement.executeUpdate();

            System.out.println("Song added.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // READ
    public ArrayList<String> getAllSongs() {

        ArrayList<String> songs = new ArrayList<>();

        String sql = """
                SELECT songs.id,
                       songs.title,
                       songs.genre,
                       songs.duration,
                       artists.name
                FROM songs
                JOIN artists
                ON songs.artist_id = artists.id
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                songs.add(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("genre") + " | " +
                                rs.getInt("duration") + " sec | " +
                                rs.getString("name")
                );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return songs;
    }

    // UPDATE
    public void updateSongGenre(int id, String genre) {

        String sql = "UPDATE songs SET genre=? WHERE id=?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, genre);
            statement.setInt(2, id);

            statement.executeUpdate();

            System.out.println("Song updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // DELETE
    public void deleteSong(int id) {

        String sql = "DELETE FROM songs WHERE id=?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.executeUpdate();

            System.out.println("Song deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}