<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>URLs - Page Analyzer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-10 mx-auto">
                <h1 class="text-center mb-4">Websites</h1>

                <!-- Flash сообщения -->
                @if(flash != null)
                    @if(flash.success != null)
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            ${flash.success}
                            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                        </div>
                    @endif
                    @if(flash.info != null)
                        <div class="alert alert-info alert-dismissible fade show" role="alert">
                            ${flash.info}
                            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                        </div>
                    @endif
                    @if(flash.error != null)
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            ${flash.error}
                            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                        </div>
                    @endif
                @endif

                <table class="table table-striped table-bordered">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>URL</th>
                            <th>Created At</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        @if(urls.isEmpty())
                            <tr>
                                <td colspan="4" class="text-center text-muted py-4">
                                    No URLs added yet. <a href="/">Add your first URL</a>
                                </td>
                            </tr>
                        @else
                            @for(url in urls)
                                <tr>
                                    <td>${url.id}</td>
                                    <td>
                                        <a href="${url.name}" target="_blank" class="text-decoration-none">
                                            ${url.name}
                                        </a>
                                    </td>
                                    <td>${url.createdAt}</td>
                                    <td>
                                        <a href="/urls/${url.id}" class="btn btn-outline-primary btn-sm">View</a>
                                    </td>
                                </tr>
                            @endfor
                        @endif
                    </tbody>
                </table>

                <div class="text-center mt-4">
                    <a href="/" class="btn btn-primary">Add New URL</a>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>