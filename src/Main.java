public class Main {

    public static void main(String[] args) {

        // ============================================
        // Создаем объекты для работы с базой данных
        // ============================================

        ArtistDAO artistDAO = new ArtistDAO();
        SongDAO songDAO = new SongDAO();

        // ============================================
        // Создаем исполнителей
        // ============================================

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

        // ============================================
        // CREATE
        // ============================================

        System.out.println("========== CREATE ==========");

        int artist1Id = artistDAO.addArtist(artist1);
        int artist2Id = artistDAO.addArtist(artist2);

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

        songDAO.addSong(song1, artist1Id);
        songDAO.addSong(song2, artist2Id);

        // ============================================
        // READ
        // ============================================

        System.out.println("\n========== ARTISTS ==========");

        for (Artist artist : artistDAO.getAllArtists()) {
            System.out.println(artist);
        }

        System.out.println("\n========== SONGS ==========");

        for (Song song : songDAO.getAllSongs()) {
            System.out.println(song);
        }

        // ============================================
        // UPDATE
        // ============================================

        System.out.println("\n========== UPDATE ==========");

        artistDAO.updateArtist(artist1Id, "USA");
        songDAO.updateSongGenre(1, "Synthwave");

        // ============================================
        // READ AFTER UPDATE
        // ============================================

        System.out.println("\n========== DATABASE AFTER UPDATE ==========");

        for (Artist artist : artistDAO.getAllArtists()) {
            System.out.println(artist);
        }

        for (Song song : songDAO.getAllSongs()) {
            System.out.println(song);
        }

        // ============================================
        // DELETE
        // ============================================

        System.out.println("\n========== DELETE ==========");

        songDAO.deleteSong(2);
        artistDAO.deleteArtist(artist2Id);

        // ============================================
        // FINAL RESULT
        // ============================================

        System.out.println("\n========== FINAL DATABASE ==========");

        for (Artist artist : artistDAO.getAllArtists()) {
            System.out.println(artist);
        }

        for (Song song : songDAO.getAllSongs()) {
            System.out.println(song);
        }

    }

}