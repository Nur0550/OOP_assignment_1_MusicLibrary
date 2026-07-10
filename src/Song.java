// Класс Song наследуется от класса Music.
public class Song extends Music {

    //extends означает, что Song наследует все возможности класса Music.

    private String genre;
    private Artist artist;

    // Конструктор.
    // super(...) вызывает конструктор родительского класса Music.
    public Song(String title, String genre, int duration, Artist artist) {
        super(title, duration);
        this.genre = genre;
        this.artist = artist;
    }

    // Getter жанра
    public String getGenre() {
        return genre;
    }

    // Setter жанра
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Getter исполнителя
    public Artist getArtist() {
        return artist;
    }

    // Setter исполнителя
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    // Реализация абстрактного метода play()
    @Override
    public void play() {
        System.out.println("Now playing: " + getTitle());
    }

    // Переопределяем метод toString()
    @Override
    public String toString() {
        return "Song{" +
                "title='" + getTitle() + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + getDuration() +
                ", artist='" + artist.getName() + '\'' +
                '}';
    }

    // Сравнение двух песен
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Song other = (Song) obj;

        return getTitle().equals(other.getTitle()) &&
                artist.getName().equals(other.artist.getName());
    }

    // hashCode должен соответствовать equals
    @Override
    public int hashCode() {
        return (getTitle() + artist.getName()).hashCode();
    }

    // Старый метод оставим, чтобы красиво выводить информацию
    public void displayInfo() {

        System.out.println("Song: " + getTitle());
        System.out.println("Genre: " + genre);
        System.out.println("Duration: " + getDuration() + " sec");
        System.out.println("Artist: " + artist.getName());
    }

}
