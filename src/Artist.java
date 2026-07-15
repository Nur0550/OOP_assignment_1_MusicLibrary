import java.util.Objects;

// ======================================================
// Класс Artist
// Хранит информацию об исполнителе.
// ======================================================

public class Artist {

    // Имя исполнителя
    private String name;

    // Страна
    private String country;

    // Возраст
    private int age;

    // Конструктор
    public Artist(String name, String country, int age) {
        this.name = name;
        this.country = country;
        this.age = age;
    }

    // Получить имя
    public String getName() {
        return name;
    }

    // Изменить имя
    public void setName(String name) {
        this.name = name;
    }

    // Получить страну
    public String getCountry() {
        return country;
    }

    // Изменить страну
    public void setCountry(String country) {
        this.country = country;
    }

    // Получить возраст
    public int getAge() {
        return age;
    }

    // Изменить возраст
    public void setAge(int age) {
        this.age = age;
    }

    // Красивый вывод объекта
    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                '}';
    }

    // Сравнение объектов
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Artist artist = (Artist) obj;

        return age == artist.age &&
                Objects.equals(name, artist.name) &&
                Objects.equals(country, artist.country);
    }

    // Генерация hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, country, age);
    }

}