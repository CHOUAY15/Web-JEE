package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.SingletonConnection;
import beans.Form;
import beans.User;

public class AuthDaoImpl implements AuthDao {
    
    @Override
    public User getOne(String nom, String mdp) throws SQLException {
      
        Connection connection = SingletonConnection.getConnection();
        
        if (connection == null) {
            throw new SQLException("prblm f connec");
        }
        
        String requete = "select * from utilisateurs where login=? and mdp=?";
        User user = null;
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, mdp);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setLogin(resultSet.getString("login")); 
                    user.setMdp(resultSet.getString("mdp"));
                }
            }
        }
        
        return user;
    }
    @Override
    public boolean addForm(Form form) throws SQLException {
        Connection connection = SingletonConnection.getConnection();
        
        if (connection == null) {
            throw new SQLException("Imposss");
        }
        
        String requete = "INSERT INTO form (initiale, nom, email, langues, domaine) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
            preparedStatement.setString(1, form.getInitiale());
            preparedStatement.setString(2, form.getNom());
            preparedStatement.setString(3, form.getEmail());
            preparedStatement.setString(4, form.getLangues());
            preparedStatement.setString(5, form.getDomaine());
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }
    @Override
    public boolean updateUser(String oldLogin,String login, String newPassword) throws SQLException {
        Connection connection = SingletonConnection.getConnection();
        
        if (connection == null) {
            throw new SQLException("Impossible d'établir une connexion à la base de données");
        }
        
  
        String checkUser = "SELECT COUNT(*) FROM utilisateurs WHERE login = ?";
        try (PreparedStatement checkStmt = connection.prepareStatement(checkUser)) {
            checkStmt.setString(1, oldLogin);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) == 0) {
                return false;
            }
        }
        
     
        String requete = "UPDATE utilisateurs SET mdp = ?, login = ? WHERE login = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, oldLogin);
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }

}