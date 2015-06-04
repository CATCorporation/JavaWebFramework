package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.CodeError;
import model.News;
import model.User;

public class DbNews {

	public static News getAllNews(){
		int error = CodeError.SUCESS;
		Connection connectionInstance = null;
		PreparedStatement statementInstance = null;
		String request = "SELECT * FROM news";

		try {
			try {
				connectionInstance = DbConnect.getConnection();
			} catch (Exception ex) {
				error = CodeError.CONNEXION_FAIL;
			}

			statementInstance = connectionInstance.prepareStatement(request);

			ResultSet result = statementInstance.executeQuery();
			result.next();
			News news = new News();
			news.setId(result.getInt("id"));
			news.setTitle(result.getString("title_news"));
			news.setText(result.getString("text_news"));
			
			User user = new User();
			user.setId(result.getInt("id_user"));
			news.setUser(user);
			
		} catch (SQLException ex) {
			error = CodeError.STATEMENT_EXECUTE_FAIL;
		} finally {
			if (statementInstance != null) {
				try {
					statementInstance.close();
				} catch (SQLException ex) {
					error = CodeError.STATEMENT_CLOSE_FAIL;
				}
			}
		}
	}
}
