public class Main {

    public static void main(String[] args) {

        // ===========================
        // Создаем DAO объекты
        // ===========================

        ArtistDAO artistDAO = new ArtistDAO();
        SongDAO songDAO = new SongDAO();

        // ===========================
        // Создаем исполнителей
        // ===========================

        Artist artist1 = new Artist(
                "The Weeknd",
                "Canada",
                35
        );

        Artist artist2 = new Artist(
                "Ed Sheeran",
                "United Kingdom",
                34
        );

        // ===========================
        // CREATE
        // ===========================

        System.out.println("===== CREATE =====");

        artistDAO.addArtist(artist1);
        artistDAO.addArtist(artist2);

        Song song1 = new Song(
                "Blinding Lights",
                "Pop",
                200,
                artist1
        );

        Song song2 = new Song(
                "Shape of You",
                "Pop",
                233,
                artist2
        );

        // Предполагаем, что artist1 получил ID = 1,
        // а artist2 получил ID = 2.
        songDAO.addSong(song1, 1);
        songDAO.addSong(song2, 2);

        // ===========================
        // READ
        // ===========================

        System.out.println("\n===== ARTISTS =====");

        for (Artist artist : artistDAO.getAllArtists()) {
            System.out.println(artist);
        }

        System.out.println("\n===== SONGS =====");

        for (String song : songDAO.getAllSongs()) {
            System.out.println(song);
        }

        // ===========================
        // UPDATE
        // ===========================

        System.out.println("\n===== UPDATE =====");

        artistDAO.updateArtist(1, "USA");
        songDAO.updateSongGenre(1, "Synthwave");

        System.out.println("Database updated.");

        // ===========================
        // READ AFTER UPDATE
        // ===========================

        System.out.println("\n===== AFTER UPDATE =====");

        for (Artist artist : artistDAO.getAllArtists()) {
            System.out.println(artist);
        }

        for (String song : songDAO.getAllSongs()) {
            System.out.println(song);
        }

        // ===========================
        // DELETE
        // ===========================

        System.out.println("\n===== DELETE =====");

        songDAO.deleteSong(2);
        artistDAO.deleteArtist(2);

        // ===========================
        // FINAL RESULT
        // ===========================

        System.out.println("\n===== FINAL DATABASE =====");

        for (Artist artist : artistDAO.getAllArtists()) {
            System.out.println(artist);
        }

        for (String song : songDAO.getAllSongs()) {
            System.out.println(song);
        }

    }

}