package Game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myGame?useSSL=false&characterSet=utf8mb4&serverTimezone=UTC","root","coderslab");
        return connection;
    }
}
