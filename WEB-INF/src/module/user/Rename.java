package module.user;

import interfaces.IMyAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import model.DbUser;
import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

public class Rename implements IMyAction{

	private Rename(){
		
	}
	
	public static Rename getInstance(){
		return renameHolder.INSTANCE;
	}
	
	private static class renameHolder{
		private static final Rename INSTANCE = new Rename();
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
		
		ArrayList<String> value = new ArrayList<String>();
		value.add("user");
		value.add("admin");
		HashMap<String, String> user = DbUser.getUser(((String[]) context
				.getParameter("renameUser"))[0]);

		out.println("<a href=\"accueil\">Accueil</a>");
		out.println("<a href=\"logout\">Deconexion</a>");
		String form = "<h2>Modifier utilisateur : " + user.get("login") + "</h2>";
		form += "<form action=\"./updateUser\" method=\"post\">" + "<div>"
				+ "<input type=\"hidden\" name=\"id\" value=\"" + user.get("id") + "\"/>" + "</div>" + "<div>"
				+ "<label for=\"login\">Login :</label>"
				+ "<input type=\"text\" name=\"login\" value=\"" + user.get("login") + "\"/>" + "</div>" + "<div>"
				+ "<label for=\"mdp\">Mot de passe :</label>"
				+ "<input type=\"text\" name=\"mdp\" value=\"" + user.get("mdp") + "\"/>" + "</div>"
				+ "<select name=\"role\">";

		for (String v : value) {
			if(v.equals(user.get("role")))
				form += "<option value=\"" + v + "\" selected=\"selected\">" + v + "</option>";	
			else
				form += "<option value=\"" + v + "\">" + v + "</option>";
		}

		form += "</select>" + "<div class=\"button\">"
				+ "<input type=\"submit\" value=\"Envoyer\"></button>"
				+ "</div></form>";

		out.println(form);

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
