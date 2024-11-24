<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="beans.User" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Details Infos</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>
    <%
        User user = (User) session.getAttribute("user");
    %>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-4">
    <div class="container">
        <span class="navbar-brand">Mon Application</span>
        <div class="d-flex align-items-center">
            <div class="dropdown d-flex align-items-center">
                <!-- Icon image added next to the dropdown button -->
                <img src="./imags/icon.png" alt="Icon" width="30" height="30" class="me-2">
                <button class="btn btn-light btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="bi bi-person-circle"></i> <%= user.getLogin() %>
                </button>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton">
                    <li><a class="dropdown-item" href="#" onclick="toggleUpdateForm()">Profil</a></li>
                    <li><a class="dropdown-item" href="#">Déconnexion</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>


  <div class="container" id="updateFormContainer" style="display: none;">
        <div class="card mb-4">
            <div class="card-header bg-primary text-white">
                <h3 class="card-title mb-0">Modifier Utilisateur</h3>
            </div>
            <div class="card-body">
                <form method="POST" action="UpdateUserServlet">
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="updateLogin" class="form-label">Login</label>
                            <input type="text" class="form-control" id="updateLogin" name="updateLogin" 
       value="<%= user.getLogin() %>">

                        </div>
                        <div class="col-md-6">
                            <label for="updatePassword" class="form-label">Nouveau mot de passe</label>
                            <input type="password" class="form-control" id="updatePassword" name="updatePassword" required>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-warning">Mettre à jour utilisateur</button>
                </form>
            </div>
        </div>
    </div>

   



    <div class="container mt-5">
        <h2 class="mb-4">Details Infos</h2>
     
    <form method="POST" action="MyServlet2">
        <div class="mb-3">
            <label for="initiale" class="form-label">Initiale</label>
            <select id="initiale" name="initiale" class="form-select" required>
                <option value="Monsieur">Monsieur</option>
                <option value="Madame">Madame</option>
            </select>
        </div>
        
        <div class="mb-3">
            <label for="nom" class="form-label">Nom complet</label>
            <input type="text" class="form-control" id="nom" name="nom" required>
        </div>
        
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        
        <div class="mb-3">
            <label for="langue" class="form-label">Langue</label>
            <select id="langue" name="langue" class="form-select" multiple>
                <option value="fr">Français</option>
                <option value="en">Arabe</option>
                <option value="es">Anglais</option>
            </select>
        </div>
        
        <div class="mb-3">
            <label class="form-label">Domaine d'intérêt</label><br>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="domaine" id="tech" value="tech">
                <label class="form-check-label" for="tech">Sport</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="domaine" id="sciences" value="sciences">
                <label class="form-check-label" for="sciences">Politique</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="domaine" id="arts" value="arts">
                <label class="form-check-label" for="arts">Economie</label>
            </div>
        </div>
        
        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-primary">Valider</button>
            <button type="reset" class="btn btn-secondary">Nettoyer</button>
        </div>
    </form>
    </div>
    
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <script>

  
    function toggleUpdateForm() {
        const formContainer = document.getElementById('updateFormContainer');
        if (formContainer.style.display === 'none') {
            formContainer.style.display = 'block';
        } else {
            formContainer.style.display = 'none';
        }
    }
</script>
</body>
</html>