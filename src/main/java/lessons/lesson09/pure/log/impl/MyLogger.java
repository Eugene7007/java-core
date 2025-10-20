package lessons.lesson09.pure.log.impl;

import lessons.lesson09.pure.jdbc.JdbcExample;
import lessons.lesson09.pure.log.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class MyLogger extends Logger {

    public MyLogger(JdbcExample jdbcExample) {
        super(jdbcExample);
    }

    @Override
    public void printInfo(Connection connection) throws SQLException {
        System.out.println("--> printInfo <--");
        long startTime = System.currentTimeMillis();
        super.printInfo(connection);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + " ms");
    }

    @Override
    public void increaseAccountBalance(Connection connection, int clientId, BigDecimal amount) throws SQLException {
        System.out.println("--> increaseAccountBalance <--");
        long startTime = System.currentTimeMillis();
        super.increaseAccountBalance(connection, clientId, amount);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + " ms");
    }

    @Override
    public void decreaseAccountBalance(Connection connection, int clientId, BigDecimal amount) throws SQLException {
        System.out.println("--> decreaseAccountBalance <--");
        long startTime = System.currentTimeMillis();
        super.decreaseAccountBalance(connection, clientId, amount);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + " ms");
    }
}
