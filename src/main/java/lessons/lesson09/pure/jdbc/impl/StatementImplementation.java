package lessons.lesson09.pure.jdbc.impl;

import lessons.lesson09.pure.jdbc.JdbcExample;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static lessons.lesson09.Constant.SELECT_ACCOUNT_INFO_SQL;


public class StatementImplementation implements JdbcExample {

    @Override
    public void printInfo(Connection connection) throws SQLException {
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(SELECT_ACCOUNT_INFO_SQL);
        printInfo(rs);
    }

    @Override
    public void increaseAccountBalance(Connection connection, int clientId, BigDecimal amount) throws SQLException {
        try {
            Statement st = connection.createStatement();
            String sql = "UPDATE accounts SET balance = balance + " + amount + " WHERE client_id = " + clientId;
            int result = st.executeUpdate(sql);

            System.out.println("Rows affected: " + result);
            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void decreaseAccountBalance(Connection connection, int clientId, BigDecimal amount) throws SQLException {
        try {
            Statement st = connection.createStatement();
            String sql = "UPDATE accounts SET balance = balance - " + amount + " WHERE client_id = " + clientId;
            int result = st.executeUpdate(sql);

            System.out.println("Rows affected: " + result);
            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
            System.out.println(e.getMessage());
        }
    }

    private void printInfo(ResultSet rs) throws SQLException {
        while (rs.next()) {
            var fullName = rs.getString("full_name");
            var balance = rs.getBigDecimal("balance");
            System.out.println(fullName + " | balance: " + balance);
        }
    }
}
