package lessons.lesson09.pure.jdbc.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CallableStatementImplementation {

    public void callAddBonusProcedure(Connection connection, int clientId, BigDecimal bonus) throws SQLException {
        CallableStatement cs = connection.prepareCall("CALL add_bonus(?, ?)");
        cs.setInt(1, clientId);
        cs.setBigDecimal(2, bonus);
        cs.execute();
    }
}
