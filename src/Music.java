// ======================================================
// Абстрактный класс Music
// Родительский класс для всех музыкальных объектов.
// ======================================================

public abstract class Music {

    // Название музыкального произведения
    private String title;

    // Длительность в секундах
    private int duration;

    // Конструктор
    public Music(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    // Получить название
    public String getTitle() {
        return title;
    }

    // Изменить название
    public void setTitle(String title) {
        this.title = title;
    }

    // Получить длительность
    public int getDuration() {
        return duration;
    }

    // Изменить длительность
    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Абстрактный метод.
    // Каждый наследник должен реализовать его самостоятельно.
    public abstract void play();
}