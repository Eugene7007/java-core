package lessons.lesson09;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {

    public static final String URL = "jdbc:postgresql://localhost:5432/bank";
    public static final String USER = "user";
    public static final String PASSWORD = "123";
    public static final int POOL_SIZE = 10;

    public static final String SELECT_ACCOUNT_INFO_SQL = """
                SELECT c.full_name, a.balance
                  FROM clients c
                  JOIN accounts a ON c.id = a.client_id
            """;
}
