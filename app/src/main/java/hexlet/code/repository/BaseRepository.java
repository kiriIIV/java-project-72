package hexlet.code.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseRepository {
    private static HikariDataSource dataSource;

    public static void configureDataSource() {
        String jdbcUrl = System.getenv().getOrDefault("JDBC_DATABASE_URL",
                "jdbc:h2:mem:project;DB_CLOSE_DELAY=-1;");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setMaximumPoolSize(10);

        if (jdbcUrl.contains("postgresql")) {
            config.setDriverClassName("org.postgresql.Driver");
        }

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            configureDataSource();
        }
        return dataSource.getConnection();
    }
}