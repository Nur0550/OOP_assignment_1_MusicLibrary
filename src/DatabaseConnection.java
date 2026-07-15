import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// ======================================================
// Класс DatabaseConnection
// Отвечает за подключение к PostgreSQL.
// ======================================================

public class DatabaseConnection {

    // Адрес базы данных
    private static final String URL =
            "jdbc:postgresql://localhost:5432/music_library";

    // Имя пользователя PostgreSQL
    private static final String USER = "postgres";

    // Пароль PostgreSQL
    // ВАЖНО: Замени на свой пароль
    private static final String PASSWORD = "F2022$2022F";

    // Метод возвращает подключение к базе данных
    public static Connection getConnection() {

        try {

            Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Connected to PostgreSQL!");

            return connection;

        } catch (SQLException e) {

            System.out.println("Connection failed!");
            e.printStackTrace();

            return null;

        }

    }

}