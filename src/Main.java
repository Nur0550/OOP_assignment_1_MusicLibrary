public class Main {

    public static void main(String[] args) {

        // ======================================
        // Создаем музыкальную библиотеку
        // ======================================

        MusicLibrary library = new MusicLibrary();

        // ======================================
        // Создаем исполнителей
        // ======================================

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

        // ======================================
        // Создаем песни
        // ======================================

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

        Song song3 = new Song(
                "Starboy",
                "R&B",
                230,
                artist1
        );

        // ======================================
        // Добавляем песни в библиотеку
        // ======================================

        library.addSong(song1);
        library.addSong(song2);
        library.addSong(song3);

        // ======================================
        // Создаем пользовательский плейлист
        // ======================================

        Playlist playlist = new Playlist(
                "My Favorite Songs",
                "Nurmuhammad"
        );

        // Добавляем песни в плейлист

        playlist.addSong(song1);
        playlist.addSong(song3);

        // ======================================
        // Вывод исполнителей
        // ======================================

        System.out.println("========== ARTISTS ==========");

        System.out.println(artist1);
        System.out.println(artist2);

        // ======================================
        // Вывод библиотеки
        // ======================================

        library.displayLibrary();

        // ======================================
        // Вывод плейлиста
        // ======================================

        playlist.displayPlaylist();

        // ======================================
        // Демонстрация полиморфизма
        // ======================================

        System.out.println("\n========== PLAY ==========");

        song1.play();
        song2.play();
        song3.play();

        // ======================================
        // Поиск песни
        // ======================================

        System.out.println("\n========== SEARCH ==========");

        Song foundSong = library.findSongByTitle("Starboy");

        if (foundSong != null) {
            System.out.println(foundSong);
        } else {
            System.out.println("Song not found.");
        }

        // ======================================
        // Фильтрация
        // ======================================

        System.out.println("\n========== FILTER ==========");

        library.filterByGenre("Pop");

        // ======================================
        // Сортировка по названию
        // ======================================

        System.out.println("\n========== SORT BY TITLE ==========");

        library.sortByTitle();
        library.displayLibrary();

        // ======================================
        // Сортировка по длительности
        // ======================================

        System.out.println("\n========== SORT BY DURATION ==========");

        library.sortByDuration();
        library.displayLibrary();

        // ======================================
        // equals()
        // ======================================

        System.out.println("\n========== EQUALS ==========");

        System.out.println(
                "song1 equals song2: "
                        + song1.equals(song2)
        );

        System.out.println(
                "artist1 equals artist2: "
                        + artist1.equals(artist2)
        );

        // ======================================
        // hashCode()
        // ======================================

        System.out.println("\n========== HASHCODE ==========");

        System.out.println(
                "song1 hashCode: "
                        + song1.hashCode()
        );

        System.out.println(
                "artist1 hashCode: "
                        + artist1.hashCode()
        );

        // ======================================
        // Количество песен
        // ======================================

        System.out.println("\n========== SONG COUNT ==========");

        System.out.println(
                "Songs in library: "
                        + library.getSongCount()
        );

        System.out.println(
                "Songs in playlist: "
                        + playlist.getSongCount()
        );

    }
}