import java.util.Objects;

// ======================================================
// Класс Song
// Наследуется от абстрактного класса Music.
// ======================================================

public class Song extends Music {

    // Жанр песни
    private String genre;

    // Исполнитель песни
    private Artist artist;

    // Конструктор
    public Song(String title, String genre, int duration, Artist artist) {

        // Вызываем конструктор родительского класса
        super(title, duration);

        this.genre = genre;
        this.artist = artist;
    }

    // Получить жанр
    public String getGenre() {
        return genre;
    }

    // Изменить жанр
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Получить исполнителя
    public Artist getArtist() {
        return artist;
    }

    // Изменить исполнителя
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    // Реализация абстрактного метода из Music
    @Override
    public void play() {
        System.out.println("Playing: " + getTitle() + " by " + artist.getName());
    }

    // Красивый вывод объекта
    @Override
    public String toString() {
        return "Song{" +
                "title='" + getTitle() + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + getDuration() +
                ", artist=" + artist.getName() +
                '}';
    }

    // Сравнение объектов
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Song song = (Song) obj;

        return getDuration() == song.getDuration() &&
                Objects.equals(getTitle(), song.getTitle()) &&
                Objects.equals(genre, song.genre) &&
                Objects.equals(artist, song.artist);
    }

    // Генерация hashCode
    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), genre, getDuration(), artist);
    }

}