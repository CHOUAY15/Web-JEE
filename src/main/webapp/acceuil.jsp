<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet"
	href="./css/bootstrap.min.css">

</head>
<body>

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h2 class="card-title text-center mb-4">Login</h2>
                        <form method="post" action="MyServlet1">
                            <div class="mb-3">
                                <label for="login" class="form-label">Login:</label>
                                <input id="login" name="login" type="text" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Password:</label>
                                <input id="password" name="password" type="password" class="form-control" required>
                            </div>
                            <div class="d-grid">
                                <button type="submit" class="btn btn-primary">Authentification</button>
                            </div>
                        </form>
                                    <% String message = (String) request.getAttribute("message"); %>
<p>
    <%= message != null ? message : "" %>
</p>
                    </div>
                </div>
            </div>
        </div>

   
    </div>
    

    
    
</body>
</html>
