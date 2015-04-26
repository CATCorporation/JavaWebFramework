package module.user;

import interfaces.IMyAction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

public class Menu implements IMyAction {

	public static String URIroot = "/JavaWebFramework/explorer";

	private Menu(){
		
	}
	
	public static Menu getInstance(){
		return menuHolder.INSTANCE;
	}
	
	private static class menuHolder{
		private static final Menu INSTANCE = new Menu();
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
		out.println("<a href=\"" + URIroot + "\">Explorer</a>");
		out.println("<a href=\"userList\">Liste utilisateur</a>");
		out.println("<a href=\"logout\">Deconexion</a></p>");
		
		out.println("<h2>Chercher utilisateur</h2>");
		out.println("<form action=\"./searchUser\" method=\"post\">" + "<div>"
				+ "<label for=\"login\">Login : </label>"
				+ "<input type=\"text\" name=\"login\" />" + "</div><div>"
				+ "<input type=\"submit\" value=\"Chercher\"></button>"
				+ "</div></form>");
		
		String form = "<h2>Créer utilisateur</h2>";
		form += "<form action=\"./createUser\" method=\"post\">" + "<div>"
				+ "<label for=\"login\">Login : </label>"
				+ "<input type=\"text\" name=\"login\" />" + "</div>" + "<div>"
				+ "<label for=\"mdp\">Mot de passe :</label>"
				+ "<input type=\"text\" name=\"mdp\" />" + "</div>"
				+ "<select name=\"role\">";

		for (String v : value) {
			form += "<option value=\"" + v + "\">" + v + "</option>";
		}

		form += "</select>" + "<div class=\"button\">"
				+ "<input type=\"submit\" value=\"Envoyer\"></button>"
				+ "</div></form>";
		if (context.getSessionAttribute("role").equals("admin")) {
			out.println("<h1>Administration</h1>");
			out.println(form);
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
