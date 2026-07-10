import java.util.ArrayList;

// Класс Playlist хранит пользовательский плейлист.
public class Playlist {

    // Название плейлиста
    private String playlistName;

    // Владелец плейлиста
    private String owner;

    // Список песен в плейлисте
    private ArrayList<Song> songs;

    // Конструктор
    public Playlist(String playlistName, String owner) {
        this.playlistName = playlistName;
        this.owner = owner;
        songs = new ArrayList<>();
    }

    // Getter названия плейлиста
    public String getPlaylistName() {
        return playlistName;
    }

    // Setter названия плейлиста
    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    // Getter владельца
    public String getOwner() {
        return owner;
    }

    // Setter владельца
    public void setOwner(String owner) {
        this.owner = owner;
    }

    // Добавить песню в плейлист
    public void addSong(Song song) {
        songs.add(song);
    }

    // Удалить песню из плейлиста
    public void removeSong(Song song) {
        songs.remove(song);
    }

    // Вывести все песни плейлиста
    public void displayPlaylist() {

        System.out.println("\n===== PLAYLIST =====");
        System.out.println("Playlist: " + playlistName);
        System.out.println("Owner: " + owner);

        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("\nSongs:");

        for (Song song : songs) {
            System.out.println(song);
        }
    }

    // Количество песен в плейлисте
    public int getSongCount() {
        return songs.size();
    }

}