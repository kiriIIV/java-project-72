package gg.jte.generated.ondemand;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {14,14,14,14,14,14,15,15,16,16,18,18,18,21,21,22,22,43,43,43,43,43,43};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Page Analyzer</title>\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n</head>\n<body>\n    <div class=\"container mt-5\">\n        <div class=\"row\">\n            <div class=\"col-md-8 mx-auto\">\n                <h1 class=\"text-center mb-4\">Page Analyzer</h1>\n\n                ");
		jteOutput.writeContent("\n                ");
		if (flash != null) {
			jteOutput.writeContent("\n                    ");
			if (flash.error != null) {
				jteOutput.writeContent("\n                        <div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\n                            ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(flash.error);
				jteOutput.writeContent("\n                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\"></button>\n                        </div>\n                    ");
			}
			jteOutput.writeContent("\n                ");
		}
		jteOutput.writeContent("\n\n                <div class=\"card\">\n                    <div class=\"card-body\">\n                        <h5 class=\"card-title\">Welcome to Page Analyzer</h5>\n                        <p class=\"card-text\">\n                            This is a simple web application for analyzing web pages.\n                            Enter a URL to get started with SEO analysis.\n                        </p>\n                        <form action=\"/urls\" method=\"post\" class=\"d-flex\">\n                            <input type=\"url\" name=\"url\" class=\"form-control me-2\" placeholder=\"https://example.com\" required>\n                            <button type=\"submit\" class=\"btn btn-primary\">Analyze</button>\n                        </form>\n                    </div>\n                </div>\n            </div>\n        </div>\n    </div>\n\n    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"></script>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
