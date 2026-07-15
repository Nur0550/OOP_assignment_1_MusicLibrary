import java.util.ArrayList;

// ======================================================
// Класс Playlist
// Хранит пользовательский плейлист.
// ======================================================

public class Playlist {

    // Название плейлиста
    private String playlistName;

    // Владелец плейлиста
    private String owner;

    // Коллекция песен
    private ArrayList<Song> songs;

    // Конструктор
    public Playlist(String playlistName, String owner) {

        this.playlistName = playlistName;
        this.owner = owner;

        // Создаем пустой список песен
        songs = new ArrayList<>();
    }

    // Добавить песню
    public void addSong(Song song) {

        songs.add(song);

        System.out.println(song.getTitle() + " added to playlist.");
    }

    // Удалить песню
    public void removeSong(Song song) {

        songs.remove(song);

        System.out.println(song.getTitle() + " removed from playlist.");
    }

    // Показать плейлист
    public void displayPlaylist() {

        System.out.println("\n========== PLAYLIST ==========");
        System.out.println("Playlist: " + playlistName);
        System.out.println("Owner: " + owner);

        if (songs.isEmpty()) {

            System.out.println("Playlist is empty.");
            return;

        }

        for (Song song : songs) {
            System.out.println(song);
        }

    }

    // Количество песен
    public int getSongCount() {
        return songs.size();
    }

    // Получить список песен
    public ArrayList<Song> getSongs() {
        return songs;
    }

    // Название плейлиста
    public String getPlaylistName() {
        return playlistName;
    }

    // Владелец
    public String getOwner() {
        return owner;
    }

}