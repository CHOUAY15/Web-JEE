package dao;

import java.sql.SQLException;

import beans.Form;
import beans.User;

public interface AuthDao {
	
	User getOne(String nom,String mdp) throws SQLException;
	boolean addForm(Form form) throws SQLException;
	boolean updateUser(String oldLogin,String login, String newPassword) throws SQLException;

}
