// Класс Artist описывает исполнителя.
public class Artist {

    private String name;
    private String country;
    private int age;

    // Конструктор
    public Artist(String name, String country, int age) {
        this.name = name;
        this.country = country;
        this.age = age;
    }

    // Getter имени
    public String getName() {
        return name;
    }

    // Setter имени
    public void setName(String name) {
        this.name = name;
    }

    // Getter страны
    public String getCountry() {
        return country;
    }

    // Setter страны
    public void setCountry(String country) {
        this.country = country;
    }

    // Getter возраста
    public int getAge() {
        return age;
    }

    // Setter возраста
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

    // Сравнение объектов Artist
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Artist other = (Artist) obj;

        return name.equals(other.name) &&
                country.equals(other.country);
    }

    // hashCode должен соответствовать equals
    @Override
    public int hashCode() {
        return (name + country).hashCode();
    }

    // Вывод информации
    public void displayInfo() {
        System.out.println(this);
    }

}
