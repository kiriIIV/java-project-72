package hexlet.code;

import hexlet.code.repository.UrlRepository;
import io.javalin.Javalin;

import java.sql.SQLException;

public class App {

    public static Javalin getApp() {
        try {
            UrlRepository.createUrlsTable();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize database", e);
        }

        var app = Javalin.create();

        app.get("/", ctx -> ctx.result("Hello World"));

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}