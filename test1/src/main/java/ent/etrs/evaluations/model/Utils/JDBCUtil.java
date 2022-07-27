package ent.etrs.evaluations.model.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    private static Connection cnx = null;

    public static Connection getConnection() throws SQLException {
        if (JDBCUtil.cnx == null || JDBCUtil.cnx.isClosed()) {
            JDBCUtil.cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_ava_jdbc_evaluations", "root", "root");
        }
        JDBCUtil.cnx.setAutoCommit(true);
        return JDBCUtil.cnx;
    }

}
