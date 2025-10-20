package lessons.lesson09.pure.log;

import lessons.lesson09.pure.jdbc.JdbcExample;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class Logger implements JdbcExample {

    protected JdbcExample jdbcExample;

    public Logger(JdbcExample jdbcExample) {
        this.jdbcExample = jdbcExample;
    }

    @Override
    public void printInfo(Connection connection) throws SQLException {
        this.jdbcExample.printInfo(connection);
    }

    @Override
    public void increaseAccountBalance(Connection connection, int clientId, BigDecimal amount) throws SQLException {
        this.jdbcExample.increaseAccountBalance(connection, clientId, amount);
    }

    @Override
    public void decreaseAccountBalance(Connection connection, int clientId, BigDecimal amount) throws SQLException {
        this.jdbcExample.decreaseAccountBalance(connection, clientId, amount);
    }
}
