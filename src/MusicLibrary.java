import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// ======================================================
// Класс MusicLibrary
// Представляет музыкальную библиотеку.
// ======================================================

public class MusicLibrary {

    // Коллекция песен
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

    // Фильтрация по жанру
    public void filterByGenre(String genre) {

        System.out.println("\n===== FILTER BY GENRE =====");

        boolean found = false;

        for (Song song : songs) {

            if (song.getGenre().equalsIgnoreCase(genre)) {

                System.out.println(song);
                found = true;

            }

        }

        if (!found) {
            System.out.println("No songs found.");
        }

    }

    // Сортировка по названию
    public void sortByTitle() {

        Collections.sort(songs, Comparator.comparing(Song::getTitle));

    }

    // Сортировка по длительности
    public void sortByDuration() {

        Collections.sort(songs, Comparator.comparingInt(Song::getDuration));

    }

    // Вывод библиотеки
    public void displayLibrary() {

        System.out.println("\n===== MUSIC LIBRARY =====");

        if (songs.isEmpty()) {

            System.out.println("Library is empty.");
            return;

        }

        for (Song song : songs) {
            System.out.println(song);
        }

    }

    // Получить количество песен
    public int getSongCount() {
        return songs.size();
    }

    // Получить список песен
    public ArrayList<Song> getSongs() {
        return songs;
    }

}