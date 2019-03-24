package database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Hoang Pham
 */
public class MyConnection implements Serializable {

    public static Connection getMyConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost; databasename=Sinhvien; username=sa; password=4123";
        conn = DriverManager.getConnection(url);
        return conn;
    }
}
