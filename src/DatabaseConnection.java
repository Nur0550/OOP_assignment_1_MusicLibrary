import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Класс отвечает за подключение к базе данных PostgreSQL
public class DatabaseConnection {

    // Адрес базы данных
    private static final String URL =
            "jdbc:postgresql://localhost:5432/music_library";

    // Пользователь PostgreSQL
    private static final String USER = "postgres";

    // Введи сюда пароль, который ты задавал при установке PostgreSQL
    private static final String PASSWORD = "F2022$2022F";

    // Метод возвращает подключение к базе данных
    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (SQLException e) {

            System.out.println("Connection failed!");
            e.printStackTrace();

            return null;

        }

    }

}