package lessons.lesson09.pure.jdbc.impl;

import lessons.lesson09.pure.jdbc.JdbcExample;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static lessons.lesson09.Constant.SELECT_ACCOUNT_INFO_SQL;

public class PreparedStatementImplementation implements JdbcExample {

    private static final String INCREASE_ACCOUNT_BALANCE_SQL = """
                UPDATE accounts
                   SET balance = balance + ?
                 WHERE client_id = ?
            """;
    private static final String DECREASE_ACCOUNT_BALANCE_SQL = """
                UPDATE accounts
                   SET balance = balance - ?
                 WHERE client_id = ?
            """;

    @Override
    public void printInfo(Connection connection) throws SQLException {
        PreparedStatement st = connection.prepareStatement(SELECT_ACCOUNT_INFO_SQL);
        ResultSet rs = st.executeQuery();

        printInfo(rs);
    }

    @Override
    public void increaseAccountBalance(Connection connection, int clientId, BigDecimal amount) throws SQLException {
        try {
            PreparedStatement ps = connection.prepareStatement(INCREASE_ACCOUNT_BALANCE_SQL);
            ps.setInt(2, clientId);
            ps.setBigDecimal(1, amount);
            ps.executeUpdate();

            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void decreaseAccountBalance(Connection connection, int clientId, BigDecimal amount) throws SQLException {
        try {
            PreparedStatement ps = connection.prepareStatement(DECREASE_ACCOUNT_BALANCE_SQL);
            ps.setInt(2, clientId);
            ps.setBigDecimal(1, amount);
            ps.executeUpdate();

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
