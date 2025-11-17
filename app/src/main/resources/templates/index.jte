<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page Analyzer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-8 mx-auto">
                <h1 class="text-center mb-4">Page Analyzer</h1>
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Welcome to Page Analyzer</h5>
                        <p class="card-text">
                            This is a simple web application for analyzing web pages.
                            Enter a URL to get started with SEO analysis.
                        </p>
                        <form action="/urls" method="post" class="d-flex">
                            <input type="text" name="url" class="form-control me-2" placeholder="Enter URL" required>
                            <button type="submit" class="btn btn-primary">Analyze</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>