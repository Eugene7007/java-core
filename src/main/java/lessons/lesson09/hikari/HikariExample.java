package lessons.lesson09.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static lessons.lesson09.Constant.PASSWORD;
import static lessons.lesson09.Constant.POOL_SIZE;
import static lessons.lesson09.Constant.SELECT_ACCOUNT_INFO_SQL;
import static lessons.lesson09.Constant.URL;
import static lessons.lesson09.Constant.USER;

public class HikariExample {

    public static void main(String[] args) throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(POOL_SIZE);

        DataSource ds = new HikariDataSource(config);

        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ACCOUNT_INFO_SQL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(rs.getString("full_name"));
            }
        }
    }
}
