package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import model.CodeError;
import model.Role;
import model.User;

public class DbUser {

	public static int connectUser(User user) {
		int error = CodeError.SUCESS;
		Connection connectionInstance = null;
		PreparedStatement statementInstance = null;
		String request = "SELECT count(*), id FROM users where login = ? and password = ?;";

		try {
			try {
				connectionInstance = DbConnect.getConnection();
			} catch (Exception ex) {
				error = CodeError.CONNEXION_FAIL;
			}

			statementInstance = connectionInstance.prepareStatement(request);

			statementInstance.setString(1, user.getLogin());
			statementInstance.setString(2, user.getPassword());

			ResultSet result = statementInstance.executeQuery();
			result.next();
			assignRole(user);
			
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

	public static int insertUser(User user) {
		int error;
		Connection connectionInstance = null;
		PreparedStatement statementInstance = null;
		String request = "INSERT INTO users(login, password, id_role) VALUES (?, ?, ?);";

		try {
			try {
				connectionInstance = DbConnect.getConnection();
			} catch (Exception ex) {
				error = CodeError.CONNEXION_FAIL;
				return error;
			}

			statementInstance = connectionInstance.prepareStatement(request);
			statementInstance.setString(1, user.getLogin());
			statementInstance.setString(2, user.getPassword());
			statementInstance.setInt(3, user.getRole().getId());

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

	public static int updateUser(User user) {
		int error;
		Connection connectionInstance = null;
		PreparedStatement statementInstance = null;
		String request = "UPDATE user " + "SET login = ?, " + "password = ?, "
				+ "id_role = ?, " + "WHERE id = ?;";

		try {
			try {
				connectionInstance = DbConnect.getConnection();
			} catch (Exception ex) {
				error = CodeError.CONNEXION_FAIL;
			}

			statementInstance = connectionInstance.prepareStatement(request);

			statementInstance.setString(1, user.getLogin());
			statementInstance.setString(2, user.getPassword());
			statementInstance.setInt(3, user.getRole().getId());
			statementInstance.setInt(4, user.getId());

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

	public static int deleteUser(User user) {
		int error = CodeError.SUCESS;
		Connection connectionInstance = null;
		PreparedStatement statementInstance = null;
		String request = "DELETE FROM user WHERE id = ?";

		try {
			try {
				connectionInstance = DbConnect.getConnection();
			} catch (Exception ex) {
				error = CodeError.CONNEXION_FAIL;
			}

			statementInstance = connectionInstance.prepareStatement(request);

			statementInstance.setInt(1, user.getId());
			statementInstance.executeQuery();
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

	public static int assignRole(User user) {
		int error = CodeError.SUCESS;
		Connection connectionInstance = null;
		PreparedStatement statementInstance = null;
		String request = "SELECT * FROM role where id = ? ";

		try {
			try {
				connectionInstance = DbConnect.getConnection();
			} catch (Exception ex) {
				error = CodeError.CONNEXION_FAIL;
			}

			statementInstance = connectionInstance.prepareStatement(request);

			statementInstance.setInt(1, user.getRole().getId());
			ResultSet result = statementInstance.executeQuery();
			result.next();
			Role role = new Role();
			role.setId(result.getInt("id"));
			role.setName(result.getString("name_role"));
			user.setRole(role);
			
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

	public static int insertRole(Role role) {
		int error;
		Connection connectionInstance = null;
		PreparedStatement statementInstance = null;
		String request = "INSERT INTO role (name_role) VALUES (?);";

		try {
			try {
				connectionInstance = DbConnect.getConnection();
			} catch (Exception ex) {
				error = CodeError.CONNEXION_FAIL;
				return error;
			}

			statementInstance = connectionInstance.prepareStatement(request);
			statementInstance.setString(1, role.getName());
			
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

	public static int updateRole(Role role) {
		int error;
		Connection connectionInstance = null;
		PreparedStatement statementInstance = null;
		String request = "UPDATE role SET name_role = ?";

		try {
			try {
				connectionInstance = DbConnect.getConnection();
			} catch (Exception ex) {
				error = CodeError.CONNEXION_FAIL;
			}

			statementInstance = connectionInstance.prepareStatement(request);

			statementInstance.setString(1, role.getName());
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

	public static int deleteRole(Role role) {
		int error;
		Connection connectionInstance = null;
		PreparedStatement statementInstance = null;
		String request = "DELETE FROM role WHERE id = ?";

		try {
			try {
				connectionInstance = DbConnect.getConnection();
			} catch (Exception ex) {
				error = CodeError.CONNEXION_FAIL;
			}

			statementInstance = connectionInstance.prepareStatement(request);

			statementInstance.setInt(1, role.getId());
			if (statementInstance.execute()) {
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
}
