// Абстрактный класс Music.
// Он содержит общие свойства для всех музыкальных объектов.
public abstract class Music {

    // Общие поля
    private String title;
    private int duration;

    // Конструктор
    public Music(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    // Getter для названия
    public String getTitle() {
        return title;
    }

    // Setter для названия
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter для длительности
    public int getDuration() {
        return duration;
    }

    // Setter для длительности
    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Абстрактный метод.
    // Каждый наследник обязан реализовать его самостоятельно.
    public abstract void play();
}
