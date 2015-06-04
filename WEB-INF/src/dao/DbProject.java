package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CodeError;
import model.News;
import model.Project;
import model.User;

public class DbProject {

	public static ArrayList<Project> getAllproject() {
		int error = CodeError.SUCESS;
		Connection connectionInstance = null;
		PreparedStatement statementInstance = null;
		String request = "SELECT * FROM project";
		ArrayList<Project> projects = new ArrayList<Project>();
		try {
			try {
				connectionInstance = DbConnect.getConnection();
			} catch (Exception ex) {
				error = CodeError.CONNEXION_FAIL;
			}

			statementInstance = connectionInstance.prepareStatement(request);

			ResultSet result = statementInstance.executeQuery();
			while (result.next()) {
				Project p = new Project();
				p.setId(result.getInt("id"));
				p.setTitle(result.getString("title_project"));
				p.setText(result.getString("text_project"));
				p.setPicture("picture_project");

				User user = new User();
				user.setId(result.getInt("id_user"));
				p.setUser(user);
				projects.add(p);
			}
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

		return projects;
	}

	public static int addProject(Project project) {
		int error = CodeError.SUCESS;
		Connection connectionInstance = null;
		PreparedStatement statementInstance = null;
		String request = "NSERT INTO project (title_project, text_project, picture_project, id_user) "
				+ "VALUES (?, ?, ?, ?);";
		try {
			try {
				connectionInstance = DbConnect.getConnection();
			} catch (Exception ex) {
				error = CodeError.CONNEXION_FAIL;
			}

			statementInstance = connectionInstance.prepareStatement(request);
			statementInstance = connectionInstance.prepareStatement(request);
			statementInstance.setString(1, project.getTitle());
			statementInstance.setString(2, project.getText());
			statementInstance.setString(3, project.getPicture());
			statementInstance.setInt(4, project.getUser().getId());

			statementInstance.executeUpdate();
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

		return error;
	}

	public static int updateProject(Project project) {
		int error;
		Connection connectionInstance = null;
		PreparedStatement statementInstance = null;
		String request = "UPDATE project " + "SET title_proejct = ?, " + "text_project = ?, "
				+ "picture_project = ?, " + "WHERE id = ?;";

		try {
			try {
				connectionInstance = DbConnect.getConnection();
			} catch (Exception ex) {
				error = CodeError.CONNEXION_FAIL;
			}

			statementInstance = connectionInstance.prepareStatement(request);

			statementInstance.setString(1, project.getTitle());
			statementInstance.setString(2, project.getText());
			statementInstance.setString(3, project.getPicture());
			statementInstance.setInt(4, project.getId());

			int statut = statementInstance.executeUpdate();

			if (statut == 1) {
				error = CodeError.SUCESS;
			} else {
				error = CodeError.FAILLURE;
			}
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
		return error;
	}

	public static int deleteProject(Project project) {
		int error = CodeError.SUCESS;
		Connection connectionInstance = null;
		PreparedStatement statementInstance = null;
		String request = "DELETE FROM project WHERE id = ?";

		try {
			try {
				connectionInstance = DbConnect.getConnection();
			} catch (Exception ex) {
				error = CodeError.CONNEXION_FAIL;
			}

			statementInstance = connectionInstance.prepareStatement(request);

			statementInstance.setInt(1, project.getId());
			statementInstance.executeUpdate();
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
		return error;
	}

}
