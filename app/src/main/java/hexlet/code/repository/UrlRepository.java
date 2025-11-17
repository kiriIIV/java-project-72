package hexlet.code.repository;

import hexlet.code.model.Url;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UrlRepository extends BaseRepository {

    public static void createUrlsTable() throws SQLException {
        String sql;

        String jdbcUrl = System.getenv().getOrDefault("JDBC_DATABASE_URL", "");
        if (jdbcUrl.contains("postgresql")) {
            sql = """
            CREATE TABLE IF NOT EXISTS urls (
                id BIGSERIAL PRIMARY KEY,
                name VARCHAR(255) NOT NULL UNIQUE,
                created_at TIMESTAMP NOT NULL
            )
            """;
        } else {
            // Для H2
            sql = """
            CREATE TABLE IF NOT EXISTS urls (
                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(255) NOT NULL UNIQUE,
                created_at TIMESTAMP NOT NULL
            )
            """;
        }

        try (var conn = getConnection();
             var stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    public static void save(Url url) throws SQLException {
        String sql = "INSERT INTO urls (name, created_at) VALUES (?, ?)";

        try (var conn = getConnection();
             var stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, url.getName());
            stmt.setTimestamp(2, Timestamp.from(url.getCreatedAt()));
            stmt.executeUpdate();

            var generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                url.setId(generatedKeys.getLong(1));
            }
        }
    }

    public static List<Url> findAll() throws SQLException {
        var sql = "SELECT * FROM urls ORDER BY created_at DESC";
        var result = new ArrayList<Url>();

        try (var conn = getConnection();
             var stmt = conn.prepareStatement(sql)) {

            var resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                var url = new Url();
                url.setId(resultSet.getLong("id"));
                url.setName(resultSet.getString("name"));
                url.setCreatedAt(resultSet.getTimestamp("created_at").toInstant());
                result.add(url);
            }
        }
        return result;
    }

    public static Optional<Url> findByName(String name) throws SQLException {
        String sql = "SELECT * FROM urls WHERE name = ?";

        try (var conn = getConnection();
             var stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            var resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                var url = new Url();
                url.setId(resultSet.getLong("id"));
                url.setName(resultSet.getString("name"));
                url.setCreatedAt(resultSet.getTimestamp("created_at").toInstant());
                return Optional.of(url);
            }
            return Optional.empty();
        }
    }

    public static Optional<Url> findById(Long id) throws SQLException {
        String sql = "SELECT * FROM urls WHERE id = ?";

        try (var conn = getConnection();
             var stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                var url = new Url();
                url.setId(resultSet.getLong("id"));
                url.setName(resultSet.getString("name"));
                url.setCreatedAt(resultSet.getTimestamp("created_at").toInstant());
                return Optional.of(url);
            }
            return Optional.empty();
        }
    }
}