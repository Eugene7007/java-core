package lessons.lesson09.pure;

import lessons.lesson09.pure.jdbc.impl.CallableStatementImplementation;
import lessons.lesson09.pure.jdbc.impl.PreparedStatementImplementation;
import lessons.lesson09.pure.jdbc.impl.StatementImplementation;
import lessons.lesson09.pure.jdbc.JdbcExample;
import lessons.lesson09.pure.log.Logger;
import lessons.lesson09.pure.log.impl.MyLogger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static lessons.lesson09.Constant.PASSWORD;
import static lessons.lesson09.Constant.URL;
import static lessons.lesson09.Constant.USER;

public class Main {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false);

            JdbcExample stExample = new StatementImplementation();
            Logger stLogger = new MyLogger(stExample);
            JdbcExample psExample = new PreparedStatementImplementation();
            Logger psLogger = new MyLogger(psExample);

            // Statement
            stLogger.printInfo(conn);
            System.out.println("--- ---");
            stLogger.increaseAccountBalance(conn, 1, new BigDecimal(200));
            System.out.println("--- ---");
            stLogger.decreaseAccountBalance(conn, 1, new BigDecimal(200));
            System.out.println("--- ---");

            // PreparedStatement
            psLogger.printInfo(conn);
            System.out.println("--- ---");
            psLogger.increaseAccountBalance(conn, 1, new BigDecimal(100));
            System.out.println("--- ---");
            psLogger.decreaseAccountBalance(conn, 1, new BigDecimal(100));
            System.out.println("--- ---");

            // CallableStatement
            var cs = new CallableStatementImplementation();
            cs.callAddBonusProcedure(conn, 1, new BigDecimal(25));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
