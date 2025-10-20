package lessons.lesson09.pure.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public interface JdbcExample {

    void printInfo(Connection connection) throws SQLException;
    void increaseAccountBalance(Connection connection, int clientId, BigDecimal amount) throws SQLException;
    void decreaseAccountBalance(Connection connection, int clientId, BigDecimal amount) throws SQLException;
}
