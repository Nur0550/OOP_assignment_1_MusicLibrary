import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Главная музыкальная библиотека.
// Здесь хранится вся коллекция песен.
public class MusicLibrary {

    // Общая коллекция песен
    private ArrayList<Song> songs;

    // Конструктор
    public MusicLibrary() {
        songs = new ArrayList<>();
    }

    // Добавление песни
    public void addSong(Song song) {
        songs.add(song);
    }

    // Удаление песни
    public void removeSong(Song song) {
        songs.remove(song);
    }

    // Поиск песни по названию
    public Song findSongByTitle(String title) {

        for (Song song : songs) {

            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }

        }

        return null;
    }

    // Поиск всех песен определенного жанра
    public void filterByGenre(String genre) {

        System.out.println("\nSongs with genre: " + genre);

        for (Song song : songs) {

            if (song.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(song);
            }

        }

    }

    // Сортировка по названию
    public void sortByTitle() {

        Collections.sort(songs,
                Comparator.comparing(Song::getTitle));

    }

    // Сортировка по длительности
    public void sortByDuration() {

        Collections.sort(songs,
                Comparator.comparingInt(Song::getDuration));

    }

    // Вывод всей библиотеки
    public void displayLibrary() {

        System.out.println("\n===== MUSIC LIBRARY =====");

        for (Song song : songs) {
            System.out.println(song);
        }

    }

    // Возвращает количество песен
    public int getSongCount() {
        return songs.size();
    }

}
