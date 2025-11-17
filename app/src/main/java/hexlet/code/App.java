package hexlet.code;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.ResourceCodeResolver;
import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import hexlet.code.util.UrlUtils;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    private static TemplateEngine createTemplateEngine() {
        ClassLoader classLoader = App.class.getClassLoader();
        ResourceCodeResolver codeResolver = new ResourceCodeResolver("templates", classLoader);
        return TemplateEngine.create(codeResolver, ContentType.Html);
    }

    public static Javalin getApp() {
        try {
            UrlRepository.createUrlsTable();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize database", e);
        }

        var app = Javalin.create(config -> {
            config.fileRenderer(new JavalinJte(createTemplateEngine()));
        });

        app.get("/", ctx -> {
            Map<String, Object> model = new HashMap<>();
            model.put("flash", ctx.sessionAttribute("flash"));
            ctx.sessionAttribute("flash", null);
            ctx.render("index.jte", model);
        });

        // Добавляем URL
        app.post("/urls", ctx -> {
            String urlValue = ctx.formParam("url");
            Map<String, String> flash = new HashMap<>();

            if (urlValue == null || urlValue.trim().isEmpty()) {
                flash.put("error", "URL не может быть пустым");
                ctx.sessionAttribute("flash", flash);
                ctx.redirect("/");
                return;
            }

            try {
                String normalizedUrl = UrlUtils.normalizeUrl(urlValue.trim());

                // Проверяем существует ли уже такой URL
                var existingUrl = UrlRepository.findByName(normalizedUrl);
                if (existingUrl.isPresent()) {
                    flash.put("info", "Страница уже существует");
                    ctx.sessionAttribute("flash", flash);
                    ctx.redirect("/urls");
                    return;
                }

                // Сохраняем новый URL
                Url url = new Url(normalizedUrl);
                UrlRepository.save(url);

                flash.put("success", "Страница успешно добавлена");
                ctx.sessionAttribute("flash", flash);
                ctx.redirect("/urls");

            } catch (Exception e) {
                flash.put("error", "Некорректный URL");
                ctx.sessionAttribute("flash", flash);
                ctx.redirect("/");
            }
        });

        // Список всех URL
        app.get("/urls", ctx -> {
            try {
                List<Url> urls = UrlRepository.findAll();
                Map<String, Object> model = new HashMap<>();
                model.put("urls", urls);
                model.put("flash", ctx.sessionAttribute("flash"));
                ctx.sessionAttribute("flash", null);
                ctx.render("urls/index.jte", model);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        // Конкретный URL
        app.get("/urls/{id}", ctx -> {
            try {
                Long id = Long.parseLong(ctx.pathParam("id"));
                var url = UrlRepository.findById(id);

                if (url.isEmpty()) {
                    ctx.status(404);
                    ctx.result("URL not found");
                    return;
                }

                Map<String, Object> model = new HashMap<>();
                model.put("url", url.get());
                ctx.render("urls/show.jte", model);
            } catch (NumberFormatException e) {
                ctx.status(400);
                ctx.result("Invalid URL ID");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        String port = System.getenv().getOrDefault("PORT", "7070");
        app.start(Integer.parseInt(port));
    }
}