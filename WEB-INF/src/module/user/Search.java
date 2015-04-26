package module.user;

import interfaces.IMyAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import model.DbUser;
import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

public class Search implements IMyAction {

	private Search(){
		
	}
	
	public static Search getInstance(){
		return searchHolder.INSTANCE;
	}
	
	private static class searchHolder{
		private static final Search INSTANCE = new Search();
	}
	
	@Override
	public void proceed(IContext context) {
		// TODO Auto-generated method stub
		PrintWriter out = null;
		try {
			out = context._getResponse().getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<HashMap<String, String>> usersFind = new ArrayList<HashMap<String, String>>();
		String login = ((String[]) context.getParameter("login"))[0]
				.toLowerCase();
		for (HashMap<String, String> u : DbUser.listUser) {
			if (u.get("login").matches("(.*)" + login + "(.*)")) {
				usersFind.add(u);
			}
		}
		out.println("<a href=\"accueil\">Accueil</a>");
		out.println("<a href=\"logout\">Deconexion</a>");
		out.println("<h2>Resultat</h2>");
		for (HashMap<String, String> u : usersFind) {
			out.println("<a href='./display?displayUser=" + u.get("id")
					+ "'>" + u.get("login") + "</a>");
			out.println("</br>");

		}
	}

	@Override
	public int setPriority(int priority) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addCredential(String role) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean needsCredentials() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasCredential(String[] roles) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IAction getTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

}
