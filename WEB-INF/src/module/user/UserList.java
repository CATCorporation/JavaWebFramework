package module.user;

import interfaces.IMyAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import model.DbUser;
import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

import render.UserToJson;

public class UserList implements IMyAction {

	private UserList(){
		
	}
	
	public static UserList getInstance(){
		return userListHolder.INSTANCE;
	}
	
	private static class userListHolder{
		private static final UserList INSTANCE = new UserList();
	}
	
	
	public void proceed(IContext context) {
		// TODO Auto-generated method stub
		PrintWriter out = null;
		try {
			out = context._getResponse().getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<String> value = new ArrayList<String>();
		value.add("user");
		value.add("admin");

		out.println("<a href=\"accueil\">Accueil</a>");
		out.println("<a href=\"logout\">Deconexion</a>");
		out.println("<h1>Liste des utilisateurs</h1>");
		for (HashMap<String, String> user : DbUser.listUser) {
			out.println("<a href='./display?displayUser=" + user.get("id")
					+ "'>" + user.get("login") + "</a>");
			out.println("</br>");
		}
		new UserToJson().render(context);

	}

	
	public int setPriority(int priority) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void addCredential(String role) {
		// TODO Auto-generated method stub

	}

	
	public boolean needsCredentials() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean hasCredential(String[] roles) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public IAction getTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

}
