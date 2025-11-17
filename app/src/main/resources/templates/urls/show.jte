<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${url.name} - Page Analyzer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-8 mx-auto">
                <nav aria-label="breadcrumb" class="mb-4">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                        <li class="breadcrumb-item"><a href="/urls">URLs</a></li>
                        <li class="breadcrumb-item active">${url.name}</li>
                    </ol>
                </nav>

                <h1 class="text-center mb-4">URL Details</h1>

                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Website Information</h5>
                    </div>
                    <div class="card-body">
                        <table class="table table-borderless">
                            <tr>
                                <th class="w-25">ID:</th>
                                <td>${url.id}</td>
                            </tr>
                            <tr>
                                <th>URL:</th>
                                <td>
                                    <a href="${url.name}" target="_blank" class="text-decoration-none">
                                        ${url.name}
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <th>Created At:</th>
                                <td>${url.createdAt}</td>
                            </tr>
                        </table>
                    </div>
                </div>

                <!-- Место для будущих проверок SEO -->
                <div class="card mt-4">
                    <div class="card-header">
                        <h5 class="card-title mb-0">SEO Analysis</h5>
                    </div>
                    <div class="card-body">
                        <p class="text-muted">SEO analysis will be available in the next steps.</p>
                    </div>
                </div>

                <div class="text-center mt-4">
                    <a href="/urls" class="btn btn-secondary me-2">← Back to URLs</a>
                    <a href="/" class="btn btn-primary">Add New URL</a>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>